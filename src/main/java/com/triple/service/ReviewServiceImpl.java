package com.triple.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.ReviewDto;
import com.triple.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final ReviewMapper reviewMapper;

	@Override
	public List<ReviewDto> getAllReviewInfo() {
		log.info("request - ReviewService getAllReviewInfo");

		return reviewMapper.getAllReviewInfo();
	}

	@Override
	public ReviewDto getReviewInfo(String reviewid) {
		log.info("request - ReviewService getReviewInfo");

		return reviewMapper.getReviewInfo(reviewid);
	}

	@Override
	public ReviewDto getPlaceFirstReview(String placeid) {
		log.info("request - ReviewService getPlaceFirstReview - placeid : " + placeid);

		return reviewMapper.getPlaceFirstReview(placeid);
	}

	@Override
	@Transactional
	public boolean createReviewData(ReviewDto requestDto) {
		log.info("request - ReviewService createReviewData - placeid : " + requestDto.getPlaceId() + ", "
				+ requestDto.getReviewId());

		return reviewMapper.createReviewData(requestDto) == 1;
	}
}
