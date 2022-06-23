package com.triple.mapper;

import java.util.List;

import com.triple.dto.ReviewDto;

public interface ReviewMapper {
	
	public List<ReviewDto> getAllReviewInfo();
	
	public ReviewDto getReviewInfo(String reviewid);
	
	public ReviewDto getPlaceFirstReview(String placeid);

	public int createReviewData(ReviewDto requestDto);
}