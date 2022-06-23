package com.triple.service;

import java.util.List;

import com.triple.dto.AttachedPhotoDto;

public interface AttachedPhotoService {

	public AttachedPhotoDto getPhotoInfo(String photoid);

	public List<AttachedPhotoDto> getSpecificAcitivityPhotoInfo(String activityId);

	public boolean createPhotoData(AttachedPhotoDto requestDto);

}
