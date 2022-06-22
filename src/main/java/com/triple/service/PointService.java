package com.triple.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.triple.dto.PointDto;

public interface PointService {
	
	public List<PointDto> getAllUserPoint() throws Exception;

	public List<PointDto> getAllPointRecords() throws Exception;
	
	public PointDto getUserPoint(String userid) throws Exception;

	public List<PointDto> getUserPointRecords(String userid) throws Exception;
	
	public boolean uploadReview(ConcurrentHashMap<String, Object> event);

	public boolean modifyReview(ConcurrentHashMap<String, Object> event);

	public boolean deleteReview(ConcurrentHashMap<String, Object> event);

}
