package com.triple.mapper;

import com.triple.dto.PlaceDto;

public interface PlaceMapper {
	
	public PlaceDto getPlaceInfo(String placeid);

	public int createPlaceData(PlaceDto requestDto);

}