package com.triple.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.triple.dto.PointDto;

public interface PointService {
	
	public List<PointDto> getAllUserPoint();

	public List<PointDto> getAllPointRecords();
	
	public PointDto getUserPoint(String userid);

	public List<PointDto> getUserPointRecords(String userid);
	
	public boolean uploadReview(ConcurrentHashMap<String, Object> event);

	public boolean modifyReview(ConcurrentHashMap<String, Object> event);

	public boolean deleteReview(ConcurrentHashMap<String, Object> event);

}
