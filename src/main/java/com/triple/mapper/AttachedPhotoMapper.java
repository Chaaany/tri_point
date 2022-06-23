package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.AttachedPhotoDto;

public interface AttachedPhotoMapper {

	public List<AttachedPhotoDto> getAllPhotoInfo() throws SQLException;
	
	public AttachedPhotoDto getPhotoInfo(String photoid) throws SQLException;

	public List<AttachedPhotoDto> getSpecificAcitivityPhotoInfo(String activityid) throws SQLException;

	public int createPhotoData(AttachedPhotoDto requestDto) throws SQLException;
	
}