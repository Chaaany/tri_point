package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.ReviewDto;

public interface ReviewMapper {
	
	public List<ReviewDto> getAllReviewInfo() throws SQLException;
	
	public ReviewDto getReviewInfo(String reviewid) throws SQLException;
	
	public ReviewDto getPlaceFirstReview(String placeid);
}