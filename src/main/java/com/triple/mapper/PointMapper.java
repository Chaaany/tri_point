package com.triple.mapper;

import java.util.List;

import com.triple.dto.PointDto;

public interface PointMapper {

	public int createPointData(PointDto pointdto);

	public List<PointDto> getAllUserPoint();

	public List<PointDto> getAllPointRecords();

	public PointDto getUserPoint(String userid);
	
	public List<PointDto> getUserPointRecords(String userid);

	public List<PointDto> getUserPointRecordsOfSpecificActivity(String userid, String activityid);
}