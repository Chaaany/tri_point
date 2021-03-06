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

		// ?????? ????????? ???????????? db ???????????? ??????
		// ?????? ??????id ?????? ?????? ??????
		placedto = placeService.getPlaceInfo(placeId);
		if (placedto == null || placedto.getIsDeleted() == 1) 
			throw new CustomException(PLACE_NOT_FOUND);

		// ?????? ??????id ?????? ?????? ??????
		userdto = userService.getUserInfo(userId);
		if (userdto == null || userdto.getIsUnsigned() == 1) 
			throw new CustomException(USER_NOT_FOUND);

		// ?????? ??????id ?????? ?????? ??????
		reviewdto = reviewService.getReviewInfo(reviewId);
		if (reviewdto == null || reviewdto.getIsDeleted() == 1) 
			throw new CustomException(REVIEW_NOT_FOUND);
		else if (!reviewdto.getPlaceId().equals(placeId) || !reviewdto.getUserId().equals(userId)	|| !reviewdto.getContent().equals(content))
			throw new CustomException(REVIEW_INFO_NOT_MATCHED);

		// ?????? ??????id && ??????id??? ????????? ?????? 1??? ?????? ?????? ?????? ??????
		log.debug(placeId, userId);
		List<ReviewDto> reviewlist = reviewService.getplaceReviewOfSpecificUser(placeId, userId);
		
		if(reviewlist.size() > 1) 
			throw new CustomException(REVIEW_INFO_NOT_MATCHED);

		// ?????? ?????? ?????? ?????? ?????? (event ???????????? ?????? ?????? attachedPhotoids??? DB??? ?????? ?????? ??????)
		if (attachedPhotoIds.size() != 0) {
			for (String photoId : attachedPhotoIds) {
				attachedPhotodto = attachedPhotoService.getPhotoInfo(photoId);
				if (attachedPhotodto == null || attachedPhotodto.getIsDeleted() == 1) 
					throw new CustomException(ATTACHED_PHOTO_NOT_FOUND);
				else if (!attachedPhotodto.getUploadUserId().equals(userId) || !attachedPhotodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}
		
		// ?????? reviewId??? ???????????? ?????? ?????? ??????
		List<AttachedPhotoDto> attachedPhotoList = attachedPhotoService.getSpecificAcitivityPhotoInfo(activityId);
		if(attachedPhotoList.size() == attachedPhotoIds.size()){
			for (AttachedPhotoDto photodto : attachedPhotoList) {
				if (!photodto.getUploadUserId().equals(userId) || !photodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}else {
			throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
		}

		// ?????? ?????? ?????? ?????? ?????? ?????? ????????? ?????? ?????? ?????? ?????? ??????
		// userid, activityId??? point ?????? ?????? 
		List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

		// ?????? ?????? ?????? ????????? ?????? ?????? ??????
		int currentPointList[] = new int[3]; // 1 ~ 6 +/- ?????????
		
		for (PointDto pointdto : pointList) {
			currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
		}

		for (int i = 0; i < currentPointList.length; i++) {
			if (currentPointList[i] != 0) 
				throw new CustomException(POINT_RECORD_ALREADY_EXISTED);
		}

		// ?????? ????????? ?????? ??? ?????? ??? ?????? ?????? ????????? ?????? ??????(+1)
		boolean isFirstReview = reviewService.getPlaceFirstReview(placeId).getReviewId().equals(reviewId) ? true
				: false;
		if (isFirstReview) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.ADD_POINT_REVIEW_FIRST.getValue(), activityId,
					PointScore.BONUS.getValue(), PointType.REVIEW_BONUS.getValue()));

		// ?????? ?????? ?????? 1??? ?????? ??? ?????? point + 1???
		boolean isOneOrMoreWordContent = content.length() > 0 ? true : false;
		if (isOneOrMoreWordContent) 
			pointMapper.createPointData(new PointDto(userId, ActivityType.ADD_POINT_REVIEW_CONTENT.getValue(), activityId,
					PointScore.BASIC.getValue(), PointType.REVIEW_BASIC.getValue()));

		// ?????? ?????? ?????? 1??? ?????? ??? ?????? point + 1???
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
		
		// ?????? ????????? ???????????? db ???????????? ??????
		// ?????? ??????id ?????? ?????? ??????
		placedto = placeService.getPlaceInfo(placeId);
		if (placedto == null || placedto.getIsDeleted() == 1) 
			throw new CustomException(PLACE_NOT_FOUND);
		

		// ?????? ??????id ?????? ?????? ??????
		userdto = userService.getUserInfo(userId);
		if (userdto == null || userdto.getIsUnsigned() == 1) 
			throw new CustomException(USER_NOT_FOUND);
		

		// ?????? ??????id ?????? ?????? ??????
		reviewdto = reviewService.getReviewInfo(reviewId);
		if (reviewdto == null || reviewdto.getIsDeleted() == 1) 
			throw new CustomException(REVIEW_NOT_FOUND);
		else if (!reviewdto.getPlaceId().equals(placeId) || !reviewdto.getUserId().equals(userId) || !reviewdto.getContent().equals(content)) 
			throw new CustomException(REVIEW_INFO_NOT_MATCHED);
		

		// ?????? ?????? ?????? ?????? ?????? (event ???????????? ?????? ?????? attachedPhotoids??? DB??? ?????? ?????? ??????)
		if(attachedPhotoIds != null) {
			for (String photoId : attachedPhotoIds) {
				attachedPhotodto = attachedPhotoService.getPhotoInfo(photoId);
				if (attachedPhotodto == null || attachedPhotodto.getIsDeleted() == 1) 
					throw new CustomException(ATTACHED_PHOTO_NOT_FOUND);
				else if (!attachedPhotodto.getUploadUserId().equals(userId) || !attachedPhotodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}
		
		// ?????? reviewId??? ???????????? ?????? ?????? ??????
		List<AttachedPhotoDto> attachedPhotoList = attachedPhotoService.getSpecificAcitivityPhotoInfo(activityId);
		if(attachedPhotoIds != null && attachedPhotoList.size() == attachedPhotoIds.size() || attachedPhotoIds == null){
			for (AttachedPhotoDto photodto : attachedPhotoList) {
				if (!photodto.getUploadUserId().equals(userId) || !photodto.getAttachedActivityId().equals(activityId)) 
					throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
			}
		}else {
			throw new CustomException(ATTACHED_PHOTO_INFO_NOT_MATCHED);
		}


		// userid, activityId??? point ?????? ??????
		List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

		// ?????? ?????? ?????? ????????? ?????? ?????? ??????
		int currentPointList[] = new int[3]; // 1 ~ 6 +/- ?????????

		for (PointDto pointdto : pointList) {
			currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
		}

		// ???????????? ??? ?????? ??????
		boolean isAddReviewContentPointNeed = currentPointList[ActivityType.ADD_POINT_REVIEW_CONTENT.getValue()
				% 3] == 0 && content.length() > 0;
		// ???????????? ??? ?????? ??????
		boolean isMinusReviewContentPointNeed = currentPointList[ActivityType.MINUS_POINT_REVIEW_CONTENT.getValue()
				% 3] != 0 && content.length() == 0;
		// ???????????? ??? ?????? ??????
		boolean isAddReviewPhotoPointNeed = currentPointList[ActivityType.ADD_POINT_REVIEW_PHOTO.getValue() % 3] == 0
				&& attachedPhotoIds.size() > 0;
		// ???????????? ??? ?????? ?????? ??????
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

		// ?????? ????????? ???????????? db ???????????? ??????
		// ?????? ??????id ?????? ?????? ??????
		placedto = placeService.getPlaceInfo(placeId);
		if (placedto == null || placedto.getIsDeleted() == 1) 
			throw new CustomException(PLACE_NOT_FOUND);

		// ?????? ??????id ?????? ?????? ??????
		userdto = userService.getUserInfo(userId);
		if (userdto == null || userdto.getIsUnsigned() == 1) 
			throw new CustomException(USER_NOT_FOUND);

		// ?????? ??????id ?????? ?????? ??????
		reviewdto = reviewService.getReviewInfo(reviewId);
		if (!(reviewdto != null && reviewdto.getIsDeleted() == 1)) 
			throw new CustomException(REVIEW_NOT_DELETED);

		// ?????? ?????? ?????? ?????? ?????? (event ???????????? ?????? ?????? attachedPhotoids??? DB??? ?????? ?????? ??????) && ?????? reviewId??? ???????????? ?????? ?????? ??????
		List<AttachedPhotoDto> attachedPhotoList = attachedPhotoService.getSpecificAcitivityPhotoInfo(activityId);
		if (attachedPhotoIds != null || attachedPhotoList.size() != 0 ) 
			throw new CustomException(ATTACHED_PHOTO_NOT_DELETED);
		

		List<PointDto> pointList = pointMapper.getUserPointRecordsOfSpecificActivity(userId, activityId);

		// ?????? ?????? ?????? ????????? ?????? ?????? ??????
		int currentPointList[] = new int[3]; // 1 ~ 6 +/- ?????????

		for (PointDto pointdto : pointList) {
			currentPointList[pointdto.getActivityType() % 3] += pointdto.getPointScore();
		}

		// ??? ?????? ????????? ????????? ?????? ?????? ??????
		boolean isFirstReviewPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_FIRST.getValue() % 3] > 0
				&& (reviewService.getPlaceFirstReview(placeId) == null || ( reviewService.getPlaceFirstReview(placeId) != null && !reviewService.getPlaceFirstReview(placeId).getUserId().equals(userId)));

		// ?????? ?????? ?????? ????????? ?????? ?????? ??????
		boolean isReviewContentPointExisted = currentPointList[ActivityType.ADD_POINT_REVIEW_CONTENT.getValue()	% 3] > 0;

		// ?????? ?????? ?????? ????????? ?????? ?????? ??????
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
