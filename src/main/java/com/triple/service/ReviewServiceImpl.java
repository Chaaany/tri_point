package com.triple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.ReviewDto;
import com.triple.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public List<ReviewDto> getAllReview() throws Exception {
		return reviewMapper.getAllReview();
	}

	@Override
	@Transactional
	public boolean uploadReview(ReviewDto reviewdto) throws Exception {
		return reviewMapper.uploadReview(reviewdto) == 1;
	}

	@Override
	public ReviewDto reviewInfo(String reviewid) throws Exception {
		return reviewMapper.reviewInfo(reviewid);
	}

	@Override
	@Transactional
	public boolean modifyReview(ReviewDto reviewdto) throws Exception {
		return reviewMapper.modifyReview(reviewdto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteReview(String reviewid) throws Exception {
		return reviewMapper.deleteReview(reviewid) == 1;
	}

}
