package com.triple.service;

import java.util.List;

import com.triple.dto.ReviewDto;

public interface ReviewService {

	public ReviewDto getReviewInfo(String reviewid);

	public List<ReviewDto> getplaceReviewOfSpecificUser(String placeId, String userId);

	public ReviewDto getPlaceFirstReview(String placeId);

	public boolean createReviewData(ReviewDto requestDto);

}
