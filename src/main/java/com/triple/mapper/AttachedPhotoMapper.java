package com.triple.mapper;

import java.util.List;

import com.triple.dto.AttachedPhotoDto;

public interface AttachedPhotoMapper {

	public List<AttachedPhotoDto> getAllPhotoInfo();
	
	public AttachedPhotoDto getPhotoInfo(String photoid);

	public List<AttachedPhotoDto> getSpecificAcitivityPhotoInfo(String activityid); 

	public int createPhotoData(AttachedPhotoDto requestDto);
	
}