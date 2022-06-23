package com.triple.service;

import java.util.List;

import com.triple.dto.PointDto;
import com.triple.dto.ReviewEventRequestDto;

public interface PointService {
	
	public List<PointDto> getAllUserPoint() throws Exception;

	public List<PointDto> getAllPointRecords() throws Exception;
	
	public PointDto getUserPoint(String userid) throws Exception;

	public List<PointDto> getUserPointRecords(String userid) throws Exception;
	
	public boolean uploadReview(ReviewEventRequestDto eventRequestDto);

	public boolean modifyReview(ReviewEventRequestDto eventRequestDto);

	public boolean deleteReview(ReviewEventRequestDto eventRequestDto);

}
