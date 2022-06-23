package com.triple.service;

import java.util.List;

import com.triple.dto.ReviewDto;

public interface ReviewService {

	public List<ReviewDto> getAllReviewInfo();

	public ReviewDto getReviewInfo(String reviewid);

	public ReviewDto getPlaceFirstReview(String placeId);

	public boolean createReviewData(ReviewDto requestDto);

}
