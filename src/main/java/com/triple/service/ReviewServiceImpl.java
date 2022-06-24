package com.triple.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.triple.constants.ErrorCode.REVIEW_RECORD_ALREADY_EXISTED;
import com.triple.dto.ReviewDto;
import com.triple.exception.CustomException;
import com.triple.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final ReviewMapper reviewMapper;

	@Override
	@Transactional(readOnly = true)
	public ReviewDto getReviewInfo(String reviewid) {
		log.info("request - ReviewService getReviewInfo");

		return reviewMapper.getReviewInfo(reviewid);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReviewDto> getplaceReviewOfSpecificUser(String placeid, String userid) {
		log.info("request - ReviewService getplaceReviewOfSpecificUser - placeId : " + placeid + ", userId : "	+ userid);
		
		return reviewMapper.getplaceReviewOfSpecificUser(placeid, userid);
	}

	@Override
	@Transactional(readOnly = true)
	public ReviewDto getPlaceFirstReview(String placeid) {
		log.info("request - ReviewService getPlaceFirstReview - placeId : " + placeid);

		return reviewMapper.getPlaceFirstReview(placeid);
	}

	@Override
	@Transactional
	public boolean createReviewData(ReviewDto requestDto) {
		log.info("request - ReviewService createReviewData - placeId : " + requestDto.getPlaceId() + ", reviewId : " + requestDto.getReviewId());
	
		if(reviewMapper.getReviewInfo(requestDto.getReviewId()) != null) 
			throw new CustomException(REVIEW_RECORD_ALREADY_EXISTED);

		return reviewMapper.createReviewData(requestDto) == 1;
	}

}
