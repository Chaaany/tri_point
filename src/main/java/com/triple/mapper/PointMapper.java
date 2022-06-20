package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.PointDto;

public interface PointMapper {

	public List<PointDto> getAllPoint() throws SQLException;
	
	public int plusPoint(PointDto pointdto) throws SQLException;
	
	public int minusPoint(PointDto pointdto) throws SQLException;
	
	public PointDto pointInfo(String pointid) throws SQLException;
	
	public int updatePoint(PointDto pointdto) throws SQLException;

	public int deletePoint(String pointid) throws SQLException;

}