package com.triple.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.triple.constants.ActivityType;
import com.triple.constants.PointScore;
import com.triple.constants.PointType;
import com.triple.controller.MainController;
import com.triple.dto.AttachedPhotoDto;
import com.triple.dto.PlaceDto;
import com.triple.dto.PointDto;
import com.triple.dto.ReviewDto;
import com.triple.dto.ReviewEventRequestDto;
import com.triple.dto.UserDto;

import com.triple.mapper.PointMapper;

@Service
public class PointServiceImpl implements PointService {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private AttachedPhotoService attachedPhotoService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserService userService;

	@Autowired
	private PointMapper pointMapper;

	@Override
	public List<PointDto> getAllUserPoint() throws Exception {
		try {
			return pointMapper.getAllUserPoint();
		} catch (Exception e) {
			throw new Exception("get all user point");
		}
	}

	@Override
	public List<PointDto> getAllPointRecords() throws Exception {
		try {
			return pointMapper.getAllPointRecords();
		} catch (Exception e) {
			throw new Exception("get all user point records error");
		}
	}

	@Override
	public PointDto getUserPoint(String userid) throws Exception {
		
		try {
			logger.debug("" + pointMapper.getUserPoint(userid).getUserId());
			return pointMapper.getUserPoint(userid);
		} catch (Exception e) {
			logger.debug(" get user point error");
			throw new Exception("get user point error");
		}
	}

	@Override
	public List<PointDto> getUserPointRecords(String pointid) {
		try {
			return pointMapper.getUserPointRecords(pointid);
		} catch (Exception e) {
			logger.debug(" get user point records error");
			return null;
		}
	}

	@Override
	@Transactional
	public boolean uploadReview(ReviewEventRequestDto eventRequestDto) {
		String reviewId = eventRequestDto.getReviewId();
		String activityId = eventRequestDto.getReviewId();
		String content = eventRequestDto.getContent();
		List<String> attachedPhotoIds = eventRequestDto.getAttachedPhotoIds();
		String userId =  eventRequestDto.getUserId();
		String placeId = eventRequestDto.getPlaceId();
		PlaceDto placedto = null;
		UserDto userdto = null;
		ReviewDto reviewdto = null;
		AttachedPhotoDto attachedPhotodto = null;

		// 전송 데이터 id 기준으로 db 존재여부 파악
		try {
			// 해당 장소id 존재 여부 확인
			placedto = placeService.getPlaceInfo(placeId);
			if (placedto == null || placedto.getIsDeleted() == 1) {
				logger.debug(placedto +", " + placedto.getIsDeleted());
				throw new Exception("placeId : " + placeId + " not existed");
			}

			// 해당 유저id 존재 여부 확인
			userdto = userService.getUserInfo(userId);
			if (userdto == null || userdto.getIsUnsigned() == 1) {
				throw new Exception("userId : " + userId + " not existed");
			}

			// 해당 리뷰id 존재 여부 확인
			reviewdto = reviewService.getReviewInfo(reviewId);
			if (reviewdto == null || reviewdto.getIsDeleted() == 1) {
				throw new Exception("reviewId : " + reviewId + " not existed");
			} else if (!reviewdto.getPlaceId().equals(placeId)) {
				throw new Exception("placeId : " + placeId + " of review not matched");
			} else if (!reviewdto.getUserId().equals(userId)) {
				throw new Exception("userId : " + userId + " of review not matched");
			}

			// 첨부 사진 존재 여부 확인 (event 발생으로 전달 받은 id의 DB상 존재 여부 확인)
			if (attachedPhotoIds.size() != 0) {
				for (String photoId : attachedPhotoIds) {
					attachedPhotodto = attachedPhotoService.getPhotoInfo(photoId);
					if (attachedPhotodto == null || attachedPhotodto.getIsDeleted() == 1) {
						throw new Exception("photoId : " + photoId + "not existed");
					} else if (!attachedPhotodto.getUploadUserId().equals(userId)) {
						throw new Exception("userId : " + userId + " of attachedPhoto not matched");
					} else if (!attachedPhotodto.getAttachedActivityId().equals(activityId)) {
						throw new Exception("activityId : " + activityId + " of attachedPhoto not matched");
					}
				}
			}
			
			// 해당 장소 리뷰 작성 관련 과거 포인트 적립 내역 존재 여부 파악
			// userid, activityId로 point 내역 조회 -> 오름차순 조회 필요
			List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

			// 리뷰 관련 과거 포인트 적립 내역 정리
			int currentPointList[] = new int[3]; // 1 ~ 6 +/- 대응됨

			for (PointDto pointdto : pointList) {
				currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
			}
			
			for (int i = 0; i < currentPointList.length; i++) {
				if(currentPointList[i] != 0) {
					throw new Exception("already point record existed");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage() + " error");
			return false;
		}

		try {
			// 해당 장소에 리뷰 첫 리뷰 일 경우 갱신 보너스 점수 제공(+1)
			boolean isFirstReview = reviewService.getPlaceFirstReview(placeId).getReviewId().equals(reviewId) ? true : false;
			if (isFirstReview) {
				// 해당 장소 첫 리뷰 시
				PointDto pointdto = new PointDto(userId, ActivityType.ADD_POINT_REVIEW_FIRST.getValue(), activityId,
						PointScore.BONUS.getValue(), PointType.REVIEW_BONUS.getValue());
				pointMapper.createPointData(pointdto);
			}

			// 리뷰 글자 수가 1자 이상 일 경우 point + 1점
			boolean isOneOrMoreWordContent = content.length() > 0 ? true : false;
			if (isOneOrMoreWordContent) {
				PointDto pointdto = new PointDto(userId, ActivityType.ADD_POINT_REVIEW_CONTENT.getValue(), activityId,
						PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue());
				pointMapper.createPointData(pointdto);
			}

			// 첨부 사진 수가 1개 이상 일 경우 point + 1점
			boolean isOneOrMorePhoto = attachedPhotoIds.size() > 0 ? true : false;
			if (isOneOrMorePhoto) {
				PointDto pointdto = new PointDto(userId, ActivityType.ADD_POINT_REVIEW_PHOTO.getValue(), activityId,
						PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue());
				pointMapper.createPointData(pointdto);
			}
		} catch (Exception e) {
			// 하나라도 제대로 적립 안되면 오류 발생 및 rollback
			logger.debug(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
		return true;
	}

	@Override
	public boolean modifyReview(ReviewEventRequestDto eventRequestDto) {
		String reviewId = eventRequestDto.getReviewId();
		String activityId = eventRequestDto.getReviewId();
		String content = eventRequestDto.getContent();
		List<String> attachedPhotoIds = eventRequestDto.getAttachedPhotoIds();
		String userId =  eventRequestDto.getUserId();
		String placeId = eventRequestDto.getPlaceId();
		PlaceDto placedto = null;
		UserDto userdto = null;
		ReviewDto reviewdto = null;
		AttachedPhotoDto attachedPhotodto = null;
		

		try {
			// 해당 장소id 존재 여부 확인
			placedto = placeService.getPlaceInfo(placeId);
			if (placedto == null || placedto.getIsDeleted() == 1 ) {
				throw new Exception("placeId : " + placeId + " not existed");
			}

			// 해당 유저id 존재 여부 확인
			userdto = userService.getUserInfo(userId);
			if (userdto == null || userdto.getIsUnsigned() == 1) {
				throw new Exception("userId : " +userId + " not existed");
			}

			// 해당 리뷰id 존재 여부 확인
			reviewdto = reviewService.getReviewInfo(reviewId);
			if (reviewdto == null || reviewdto.getIsDeleted() == 1) {
				throw new Exception("review : " + reviewId + " not existed");
			} else if (!reviewdto.getPlaceId().equals(placeId)) {
				throw new Exception("placeId : " + placeId + " of review not matched");
			} else if (reviewdto.getUserId() != userId) {
				throw new Exception("userId : " + userId + " of review not matched");
			}

			// 첨부 사진 존재 여부 확인 (event 발생으로 전달 받은 id의 DB상 존재 여부 확인)
			if (attachedPhotoIds.size() != 0) {
				for (String photoId : attachedPhotoIds) {
					attachedPhotodto = attachedPhotoService.getPhotoInfo(photoId);
					if (attachedPhotodto == null || attachedPhotodto.getIsDeleted() == 1) {
						throw new Exception("photoId : " + photoId + "not existed");
					} else if (!attachedPhotodto.getUploadUserId().equals(userId)) {
						throw new Exception("userId : " + userId + " of attachedPhoto not matched");
					} else if (attachedPhotodto.getAttachedActivityId().equals(activityId)) {
						throw new Exception("activityId : " + activityId + " of attachedPhoto not matched");
					}
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage() + " error");
			return false;
		}

		try {
			// userid, activityId로 point 내역 조회 -> 오름차순 조회 필요
			List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

			// 리뷰 관련 과거 포인트 적립 내역 정리
			int currentPointList[] = new int[3]; // 1 ~ 6 +/- 대응됨

			for (PointDto pointdto : pointList) {
				currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
			}

			// 수정했을 때 내용 추가
			boolean isAddReviewContentPointNeed = currentPointList[ActivityType.ADD_POINT_REVIEW_CONTENT.getValue()
					% 3] == 0 && content.length() > 0;
			// 수정했을 때 내용 삭제
			boolean isMinusReviewContentPointNeed = currentPointList[ActivityType.MINUS_POINT_REVIEW_CONTENT.getValue()
					% 3] != 0 && content.length() == 0;
			// 수정했을 때 사진 추가
			boolean isAddReviewPhotoPointNeed = currentPointList[ActivityType.ADD_POINT_REVIEW_PHOTO.getValue()
					% 3] == 0 && attachedPhotoIds.size() > 0;
			// 수정했을 때 사진 모두 삭제
			boolean isMinusReviewPhotoPointNeed = currentPointList[ActivityType.MINUS_POINT_REVIEW_PHOTO.getValue()
					% 3] != 0 && attachedPhotoIds.size() == 0;
			
			if (isAddReviewContentPointNeed) { // 수정 후 글자 수 : 1 이상
				PointDto pointdto = new PointDto(userId, ActivityType.ADD_POINT_REVIEW_CONTENT.getValue(), activityId,
						PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue());
				pointMapper.createPointData(pointdto);
			} else if (isMinusReviewContentPointNeed) { // 수정 후 글자 수 : 0
				PointDto pointdto = new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_CONTENT.getValue(), activityId,
						PointScore.BASIC.getValue()*-1, PointType.REVIEW_BASIC.getValue());
				pointMapper.createPointData(pointdto);
			}else if (isAddReviewPhotoPointNeed) { 
				PointDto pointdto = new PointDto(userId, ActivityType.ADD_POINT_REVIEW_PHOTO.getValue(), activityId,
						PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue());
				pointMapper.createPointData(pointdto);
			} else if (isMinusReviewPhotoPointNeed) { // 수정 후 사진 수 : 0
				PointDto pointdto = new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_PHOTO.getValue(), activityId,
						PointScore.BASIC.getValue() * -1, PointType.REVIEW_BASIC.getValue());
			} 
			return true;
		} catch (Exception e) {
			// 하나라도 제대로 생성 안되면 오류 발생 및 rollback
			logger.debug("point data create error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}

	}

	@Override
	public boolean deleteReview(ReviewEventRequestDto eventRequestDto) {
		String reviewId = eventRequestDto.getReviewId();
		String activityId = eventRequestDto.getReviewId();
		String content = eventRequestDto.getContent();
		List<String> attachedPhotoIds = eventRequestDto.getAttachedPhotoIds();
		String userId =  eventRequestDto.getUserId();
		String placeId = eventRequestDto.getPlaceId();
		PlaceDto placedto = null;
		UserDto userdto = null;
		ReviewDto reviewdto = null;
		AttachedPhotoDto attachedPhotodto = null;

		try {
			// 해당 장소id 존재 여부 확인
			placedto = placeService.getPlaceInfo(placeId);
			if (placedto == null || placedto.getIsDeleted() == 1) {
				throw new Exception("placeId : " + placeId + " not existed");
			}

			// 해당 유저id 존재 여부 확인
			userdto = userService.getUserInfo(userId);
			if (userdto == null || userdto.getIsUnsigned() == 1) {
				throw new Exception("userId : " + userId + " not existed");
			}

			// 해당 리뷰id 존재 여부 확인 
			reviewdto = reviewService.getReviewInfo(reviewId);
			if (reviewdto == null || reviewdto.getIsDeleted() == 0) {
				throw new Exception("reviewId : " + reviewId + " not deleted");
			} 

			// 첨부 사진 존재 여부 확인 (event 발생으로 전달 받은 id의 DB상 존재 여부 확인)
			boolean isExistedPhoto = attachedPhotoService.getSpecificAcitivityPhotoInfo(activityId) == null ? true : false;
			if(isExistedPhoto)	throw new Exception("attached photo data not deleted");

		} catch (Exception e) {
			logger.debug(e.getMessage() + " error");
			return false;
		}

		
		try {
			List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

			// 리뷰 관련 과거 포인트 적립 내역 정리
			int currentPointList[] = new int[3]; // 1 ~ 6 +/- 대응됨

			for (PointDto pointdto : pointList) {
				currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
			}
			
			// 첫 리뷰 보너스 포인트 차감 필요 여부
			boolean isFirstReviewPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_FIRST.getValue() % 3] > 0 && reviewService.getPlaceFirstReview(placeId).getUserId().equals(userId);
			
			// 리뷰 내용 작성 포인트 차감 필요 여부
			boolean isReviewContentPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_CONTENT.getValue() % 3] > 0;
			
			// 리뷰 사진 첨부 포인트 차감 필요 여부
			boolean isReviewPhotoPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_CONTENT.getValue() % 3] > 0;
			
			if (isFirstReviewPointExisted) { // 삭제 후 첫 리뷰 작성으로 받은 포인트 차감
				PointDto pointdto = new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_FIRST.getValue(), activityId,
						PointScore.BONUS.getValue() * -1, PointType.REVIEW_BONUS.getValue());
				pointMapper.createPointData(pointdto);
			} else if (isReviewContentPointExisted) { // 삭제 후 내용 작성으로 받은 포인트 차감
				PointDto pointdto = new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_CONTENT.getValue(), activityId,
						PointScore.BASIC.getValue() * -1, PointType.REVIEW_BASIC.getValue());
			} else if (isReviewPhotoPointExisted) { // 삭제 후 사진 첨부 받은 포인트 차감
				PointDto pointdto = new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_PHOTO.getValue(), activityId,
						PointScore.BASIC.getValue() * -1, PointType.REVIEW_BASIC.getValue());
			} 
			return true;
		} catch (Exception e) {
			// 하나라도 제대로 생성 안되면 오류 발생 및 rollback
			logger.debug("point data create error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

}
