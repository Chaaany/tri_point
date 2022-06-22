package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.PointDto;

public interface PointMapper {

	public int createPointData(PointDto pointdto) throws SQLException;

	public List<PointDto> getAllUserPoint() throws SQLException;

	public List<PointDto> getAllPointRecords() throws SQLException;

	public PointDto getUserPoint(String userid) throws SQLException;
	
	public List<PointDto> getUserPointRecords(String userid) throws SQLException;

	public List<PointDto> getUserPointRecordsOfSpecificActivity(String userid, String activityid);
}