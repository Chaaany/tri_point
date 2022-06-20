package com.triple.service;

import java.util.List;

import com.triple.dto.ReviewDto;

public interface ReviewService {

	public List<ReviewDto> getAllReview() throws Exception;

	public boolean uploadReview(ReviewDto reviewdto) throws Exception;

	public ReviewDto reviewInfo(String reviewid) throws Exception;

	public boolean modifyReview(ReviewDto reviewdto) throws Exception;

	public boolean deleteReview(String reviewid) throws Exception;

}
