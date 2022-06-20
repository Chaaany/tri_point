package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.ReviewDto;

public interface ReviewMapper {
	
	public List<ReviewDto> getAllReview() throws SQLException;
	
	public int uploadReview(ReviewDto reviewdto) throws SQLException;
	
	public ReviewDto reviewInfo(String reviewid) throws SQLException;
	
	public int modifyReview(ReviewDto reviewdto) throws SQLException;

	public int deleteReview(String reviewid) throws SQLException;


}