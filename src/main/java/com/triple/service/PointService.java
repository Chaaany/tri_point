package com.triple.service;

import java.util.List;

import com.triple.dto.PointDto;
import com.triple.dto.ReviewEventRequestDto;

public interface PointService {
	
	public List<PointDto> getAllUserPoint();

	public List<PointDto> getAllPointRecords();
	
	public PointDto getUserPoint(String userid);

	public List<PointDto> getUserPointRecords(String userid);
	
	public boolean uploadReview(ReviewEventRequestDto eventRequestDto);

	public boolean modifyReview(ReviewEventRequestDto eventRequestDto);

	public boolean deleteReview(ReviewEventRequestDto eventRequestDto);

}
