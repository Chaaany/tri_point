package com.triple.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triple.controller.MainController;
import com.triple.dto.ReviewDto;
import com.triple.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public List<ReviewDto> getAllReviewInfo() {
		try {
			return reviewMapper.getAllReviewInfo();
		} catch (Exception e) {
			logger.debug("get all review error");
			return null;
		}
	}

	@Override
	public ReviewDto getReviewInfo(String reviewid) {
		try {
			return reviewMapper.getReviewInfo(reviewid);
		} catch (Exception e) {
			logger.debug("get review info error");
			return null;
		}
	}

	@Override
	public ReviewDto getPlaceFirstReview(String placeid) throws Exception {
		try {
			return reviewMapper.getPlaceFirstReview(placeid);
		} catch (Exception e) {
			throw new Exception("get place First Review error");
		}
	}
}
