package com.triple.mapper;

import java.sql.SQLException;

import com.triple.dto.PlaceDto;

public interface PlaceMapper {
	
	public PlaceDto getPlaceInfo(String placeid) throws SQLException;

	public int createPlaceData(PlaceDto requestDto) throws SQLException;

}