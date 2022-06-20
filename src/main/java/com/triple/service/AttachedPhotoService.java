package com.triple.service;

import java.util.List;

import com.triple.dto.AttachedPhotoDto;

public interface AttachedPhotoService {

	public List<AttachedPhotoDto> getAllPhoto() throws Exception;

	public boolean uploadPhoto(AttachedPhotoDto photodto) throws Exception;

	public AttachedPhotoDto photoInfo(String photoid) throws Exception;

	public boolean updatePhoto(AttachedPhotoDto photodto) throws Exception;

	public boolean deletePhoto(String photoid) throws Exception;

}
