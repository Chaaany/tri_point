package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.PlaceDto;

public interface PlaceMapper {

	public List<PlaceDto> getAllPlace() throws SQLException;
	
	public int uploadPlace(PlaceDto placedto) throws SQLException;
	
	public PlaceDto placeInfo(String placeid) throws SQLException;
	
	public int updatePlace(PlaceDto placedto) throws SQLException;

	public int deletePlace(String placeid) throws SQLException;


}