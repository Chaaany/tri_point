package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.AttachedPhotoDto;

public interface AttachedPhotoMapper {

	public List<AttachedPhotoDto> getAllPhoto() throws SQLException;
	
	public int uploadPhoto(AttachedPhotoDto photodto) throws SQLException;
	
	public AttachedPhotoDto photoInfo(String photoid) throws SQLException;
	
	public int updatePhoto(AttachedPhotoDto photodto) throws SQLException;

	public int deletePhoto(String photoid) throws SQLException;


}