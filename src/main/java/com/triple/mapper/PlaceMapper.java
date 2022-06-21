package com.triple.mapper;

import java.sql.SQLException;

import com.triple.dto.PlaceDto;

public interface PlaceMapper {
	
	public PlaceDto getPlaceInfo(String placeid) throws SQLException;

	public int getReviewCount(String placeid) throws SQLException;

}