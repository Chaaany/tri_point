package com.triple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.triple.dto.ReviewDto;

@Mapper
public interface ReviewMapper {
	
	public List<ReviewDto> getAllReviewInfo();
	
	public ReviewDto getReviewInfo(String reviewid);
	
	public List<ReviewDto> getplaceReviewOfSpecificUser(String placeid, String userid);

	public ReviewDto getPlaceFirstReview(String placeid);

	public int createReviewData(ReviewDto requestDto);

	public int modifyReview(ReviewDto reviewdto);

	public int deleteReview(String reviewid);
	
}