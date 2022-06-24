package com.triple.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.triple.dto.PlaceDto;

@Mapper
public interface PlaceMapper {
	
	public PlaceDto getPlaceInfo(String placeid);

	public int createPlaceData(PlaceDto requestDto);

}