package com.triple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.triple.dto.AttachedPhotoDto;

@Mapper
public interface AttachedPhotoMapper {

	public List<AttachedPhotoDto> getAllPhotoInfo();
	
	public AttachedPhotoDto getPhotoInfo(String photoid);

	public List<AttachedPhotoDto> getSpecificAcitivityPhotoInfo(String activityid); 

	public int createPhotoData(AttachedPhotoDto requestDto);
	
	public int deletePhoto(String photoid);
	
}