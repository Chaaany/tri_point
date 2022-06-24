package com.triple.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.constants.ActivityType;

import static com.triple.constants.ErrorCode.*;
import com.triple.constants.PointScore;
import com.triple.constants.PointType;

import com.triple.dto.AttachedPhotoDto;
import com.triple.dto.PlaceDto;
import com.triple.dto.PointDto;
import com.triple.dto.ReviewDto;
import com.triple.dto.ReviewEventRequestDto;
import com.triple.dto.UserDto;

import com.triple.exception.CustomException;

import com.triple.mapper.PointMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {

	private final AttachedPhotoService attachedPhotoService;

	private final PlaceService placeService;

	private final ReviewService reviewService;

	private final UserService userService;

	private final PointMapper pointMapper;

	@Override
	@Transactional(readOnly = true)
	public List<PointDto> getAllUserPoint() {
		log.info("request - pointservice getAllUserPoint");
		
		return pointMapper.getAllUserPoint();
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDto> getAllPointRecords() {
		log.info("request - Pointservice getAllPointRecords");
		
		return pointMapper.getAllPointRecords();
	}

	@Override
	@Transactional(readOnly = true)
	public PointDto getUserPoint(String userid) {
		log.info("request - Pointservice getUserPoint - userId : " + userid);
		
		return pointMapper.getUserPoint(userid);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PointDto> getUserPointRecords(String userid) {
		log.info("request - Pointservice getUserPointRecords - userId : " + userid);
		
		return pointMapper.getUserPointRecords(userid);
	}

	@Override
	@Transactional
	public String uploadReview(ReviewEventRequestDto eventRequestDto) {
		log.info("request - Pointservice uploadReview - userId : " + eventRequestDto.getUserId() +", reviewId : " + eventRequestDto.getReviewId());
		
		String reviewId = eventRequestDto.getReviewId();
		String activityId = eventRequestDto.getReviewId();
		String content = eventRequestDto.getContent();
		List<String> attachedPhotoIds = eventRequestDto.getAttachedPhotoIds();
		String userId = eventRequestDto.getUserId();
		String placeId = eventRequestDto.getPlaceId();
		
		PlaceDto placedto = null;
		UserDto userdto = null;
		ReviewDto reviewdto = null;
		AttachedPhotoDto attachedPhotodto = null;

		// 전송 데이터 기준으로 db 존재여부 파악
		// 해당 장소id 존재 여부 확인
		placedto = placeService.getPlaceInfo(placeId);
		if (placedto == null || placedto.getIsDeleted() == 1) 
			throw new CustomException(PLACE_NOT_FOUND);

		// 해당 유저id 존재 여부 확인
		userdto = userService.getUserInfo(userId);
		if (userdto == null || userdto.getIsUnsigned() == 1) 
			throw new CustomException(USER_NOT_FOUND);

		// 해당 리뷰id 존재 여부 확인
		reviewdto = reviewService.getReviewInfo(reviewId);
		if (reviewdto == null || reviewdto.getIsDeleted() == 1) 
			throw new CustomException(REVIEW_NOT_FOUND);
		else if (!reviewdto.getPlaceId().equals(placeId) || !reviewdto.getUserId().equals(userId)	|| !reviewdto.getContent().equals(content))
			throw new CustomException(REVIEW_INFO_NOT_MATCHED);

		// 해당 장소id && 유저id로 작성된 리뷰 1개 인지 확인 여부 확인
		log.debug(placeId, userId);
		List<ReviewDto> reviewlist = reviewService.getplaceReviewOfSpecificUser(placeId, userId);
		
		if(reviewlist.size() > 1) 
			throw new CustomException(REVIEW_INFO_NOT_MATCHED);

		// 첨부 사진 존재 여부 확인 (event 발생으로 전송 받은 attachedPhotoids의 DB상 존재 여부 확인)
		if (attachedPhotoIds.size() != 0) {
			for (String photoId : attachedPhotoIds) {
				attachedPhotodto = attachedPhotoService.getPhotoInfo(photoId);
				if (attachedPhotodto == null || attachedPhotodto.getIsDeleted() == 1) 
					throw new CustomException(ATTACHED_PHOTO_NOT_FOUND);
				else if (!attachedPhotodto.getUploadUserId().equals(userId) || !attachedPhotodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}
		
		// 해당 reviewId로 업로드된 첨부 사진 확인
		List<AttachedPhotoDto> attachedPhotoList = attachedPhotoService.getSpecificAcitivityPhotoInfo(activityId);
		if(attachedPhotoList.size() == attachedPhotoIds.size()){
			for (AttachedPhotoDto photodto : attachedPhotoList) {
				if (!photodto.getUploadUserId().equals(userId) || !photodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}else {
			throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
		}

		// 해당 장소 리뷰 작성 관련 과거 포인트 적립 내역 존재 여부 파악
		// userid, activityId로 point 내역 조회 
		List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

		// 리뷰 관련 과거 포인트 적립 내역 정리
		int currentPointList[] = new int[3]; // 1 ~ 6 +/- 대응됨
		
		for (PointDto pointdto : pointList) {
			currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
		}

		for (int i = 0; i < currentPointList.length; i++) {
			if (currentPointList[i] != 0) 
				throw new CustomException(POINT_RECORD_ALREADY_EXISTED);
		}

		// 해당 장소에 리뷰 첫 리뷰 일 경우 갱신 보너스 점수 제공(+1)
		boolean isFirstReview = reviewService.getPlaceFirstReview(placeId).getReviewId().equals(reviewId) ? true
				: false;
		if (isFirstReview) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.ADD_POINT_REVIEW_FIRST.getValue(), activityId,
					PointScore.BONUS.getValue(), PointType.REVIEW_BONUS.getValue()));

		// 리뷰 글자 수가 1자 이상 일 경우 point + 1점
		boolean isOneOrMoreWordContent = content.length() > 0 ? true : false;
		if (isOneOrMoreWordContent) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.ADD_POINT_REVIEW_CONTENT.getValue(), activityId,
					PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue()));

		// 첨부 사진 수가 1개 이상 일 경우 point + 1점
		boolean isOneOrMorePhoto = attachedPhotoIds.size() > 0 ? true : false;
		if (isOneOrMorePhoto) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.ADD_POINT_REVIEW_PHOTO.getValue(), activityId,
					PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue()));
		
		return "success";
	}

	@Override
	@Transactional
	public String modifyReview(ReviewEventRequestDto eventRequestDto) {
		log.info("request - Pointservice modifyReview - userId : " + eventRequestDto.getUserId() +", reviewId : " + eventRequestDto.getReviewId());
		
		String reviewId = eventRequestDto.getReviewId();
		String activityId = eventRequestDto.getReviewId();
		String content = eventRequestDto.getContent();
		List<String> attachedPhotoIds = eventRequestDto.getAttachedPhotoIds();
		String userId = eventRequestDto.getUserId();
		String placeId = eventRequestDto.getPlaceId();
		PlaceDto placedto = null;
		UserDto userdto = null;
		ReviewDto reviewdto = null;
		AttachedPhotoDto attachedPhotodto = null;
		
		// 전송 데이터 기준으로 db 존재여부 파악
		// 해당 장소id 존재 여부 확인
		placedto = placeService.getPlaceInfo(placeId);
		if (placedto == null || placedto.getIsDeleted() == 1) 
			throw new CustomException(PLACE_NOT_FOUND);
		

		// 해당 유저id 존재 여부 확인
		userdto = userService.getUserInfo(userId);
		if (userdto == null || userdto.getIsUnsigned() == 1) 
			throw new CustomException(USER_NOT_FOUND);
		

		// 해당 리뷰id 존재 여부 확인
		reviewdto = reviewService.getReviewInfo(reviewId);
		if (reviewdto == null || reviewdto.getIsDeleted() == 1) 
			throw new CustomException(REVIEW_NOT_FOUND);
		else if (!reviewdto.getPlaceId().equals(placeId) || !reviewdto.getUserId().equals(userId) || !reviewdto.getContent().equals(content)) 
			throw new CustomException(REVIEW_INFO_NOT_MATCHED);
		

		// 첨부 사진 존재 여부 확인 (event 발생으로 전송 받은 attachedPhotoids의 DB상 존재 여부 확인)
		if(attachedPhotoIds != null) {
			for (String photoId : attachedPhotoIds) {
				attachedPhotodto = attachedPhotoService.getPhotoInfo(photoId);
				if (attachedPhotodto == null || attachedPhotodto.getIsDeleted() == 1) 
					throw new CustomException(ATTACHED_PHOTO_NOT_FOUND);
				else if (!attachedPhotodto.getUploadUserId().equals(userId) || !attachedPhotodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}
		
		// 해당 reviewId로 업로드된 첨부 사진 확인
		List<AttachedPhotoDto> attachedPhotoList = attachedPhotoService.getSpecificAcitivityPhotoInfo(activityId);
		if(attachedPhotoIds != null && attachedPhotoList.size() == attachedPhotoIds.size() || attachedPhotoIds == null){
			for (AttachedPhotoDto photodto : attachedPhotoList) {
				if (!photodto.getUploadUserId().equals(userId) || !photodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}else {
			throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
		}


		// userid, activityId로 point 내역 조회
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
		boolean isAddReviewPhotoPointNeed = currentPointList[ActivityType.ADD_POINT_REVIEW_PHOTO.getValue() % 3] == 0
				&& attachedPhotoIds.size() > 0;
		// 수정했을 때 사진 모두 삭제
		boolean isMinusReviewPhotoPointNeed = currentPointList[ActivityType.MINUS_POINT_REVIEW_PHOTO.getValue()
				% 3] != 0 && attachedPhotoIds == null;

		if (isAddReviewContentPointNeed) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.ADD_POINT_REVIEW_CONTENT.getValue(), activityId,
					PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue()));
		else if (isMinusReviewContentPointNeed)  
			pointMapper.createPointData( new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_CONTENT.getValue(), activityId,
					PointScore.BASIC.getValue() * -1, PointType.REVIEW_BASIC.getValue()));
		
		if (isAddReviewPhotoPointNeed)  
			pointMapper.createPointData(new PointDto(userId, ActivityType.ADD_POINT_REVIEW_PHOTO.getValue(), activityId,
					PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue()));
		else if (isMinusReviewPhotoPointNeed) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_PHOTO.getValue(), activityId,
					PointScore.BASIC.getValue() * -1, PointType.REVIEW_BASIC.getValue()));
		
			return "success";
	}

	@Override
	@Transactional
	public String deleteReview(ReviewEventRequestDto eventRequestDto) {
		log.info("request - Pointservice deleteReview - userId : " + eventRequestDto.getUserId() +", reviewId : " + eventRequestDto.getReviewId());
		
		String reviewId = eventRequestDto.getReviewId();
		String activityId = eventRequestDto.getReviewId();
		List<String> attachedPhotoIds = eventRequestDto.getAttachedPhotoIds();
		String userId = eventRequestDto.getUserId();
		String placeId = eventRequestDto.getPlaceId();
		PlaceDto placedto = null;
		UserDto userdto = null;
		ReviewDto reviewdto = null;

		// 전송 데이터 기준으로 db 존재여부 파악
		// 해당 장소id 존재 여부 확인
		placedto = placeService.getPlaceInfo(placeId);
		if (placedto == null || placedto.getIsDeleted() == 1) 
			throw new CustomException(PLACE_NOT_FOUND);

		// 해당 유저id 존재 여부 확인
		userdto = userService.getUserInfo(userId);
		if (userdto == null || userdto.getIsUnsigned() == 1) 
			throw new CustomException(USER_NOT_FOUND);

		// 해당 리뷰id 존재 여부 확인
		reviewdto = reviewService.getReviewInfo(reviewId);
		if (!(reviewdto != null && reviewdto.getIsDeleted() == 1)) 
			throw new CustomException(REVIEW_NOT_DELETED);

		// 첨부 사진 존재 여부 확인 (event 발생으로 전송 받은 attachedPhotoids의 DB상 존재 여부 확인) && 해당 reviewId로 업로드된 첨부 사진 확인
		List<AttachedPhotoDto> attachedPhotoList = attachedPhotoService.getSpecificAcitivityPhotoInfo(activityId);
		if (attachedPhotoIds != null || attachedPhotoList.size() != 0 ) 
			throw new CustomException(ATTACHED_PHOTO_NOT_DELETED);
		

		List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

		// 리뷰 관련 과거 포인트 적립 내역 정리
		int currentPointList[] = new int[3]; // 1 ~ 6 +/- 대응됨

		for (PointDto pointdto : pointList) {
			currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
		}

		// 첫 리뷰 보너스 포인트 차감 필요 여부
		boolean isFirstReviewPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_FIRST.getValue() % 3] > 0
				&& (reviewService.getPlaceFirstReview(placeId) == null || ( reviewService.getPlaceFirstReview(placeId) != null && !reviewService.getPlaceFirstReview(placeId).getUserId().equals(userId)));

		// 리뷰 내용 작성 포인트 차감 필요 여부
		boolean isReviewContentPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_CONTENT.getValue()	% 3] > 0;

		// 리뷰 사진 첨부 포인트 차감 필요 여부
		boolean isReviewPhotoPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_CONTENT.getValue() % 3] > 0;

		if (isFirstReviewPointExisted) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_FIRST.getValue(), activityId,
					PointScore.BONUS.getValue() * -1, PointType.REVIEW_BONUS.getValue()));
		
		if (isReviewContentPointExisted)
			pointMapper.createPointData(new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_CONTENT.getValue(), activityId,
					PointScore.BASIC.getValue() * -1, PointType.REVIEW_BASIC.getValue()));
		
		if (isReviewPhotoPointExisted) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.MINUS_POINT_REVIEW_PHOTO.getValue(), activityId,
					PointScore.BASIC.getValue() * -1, PointType.REVIEW_BASIC.getValue()));
		
		return "success";
	}

}
