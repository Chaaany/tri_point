package com.triple.service;

import java.util.List;

import com.triple.dto.PointDto;
import com.triple.dto.ReviewEventRequestDto;

public interface PointService {

	public List<PointDto> getAllUserPoint();

	public List<PointDto> getAllPointRecords();

	public PointDto getUserPoint(String userid);

	public List<PointDto> getUserPointRecords(String userid);

	public String uploadReview(ReviewEventRequestDto eventRequestDto);

	public String modifyReview(ReviewEventRequestDto eventRequestDto);

	public String deleteReview(ReviewEventRequestDto eventRequestDto);

}
