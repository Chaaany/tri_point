package com.triple.service;

import java.util.List;

import com.triple.dto.PlaceDto;

public interface PlaceService {


	public List<PlaceDto> getAllPlace() throws Exception;
	
	public boolean uploadPlace(PlaceDto placedto) throws Exception;
	
	public PlaceDto placeInfo(String placeid) throws Exception;
	
	public boolean updatePlace(PlaceDto placeadto) throws Exception;

	public boolean deletePlace(String placeid) throws Exception;

}
