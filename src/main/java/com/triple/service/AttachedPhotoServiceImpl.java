package com.triple.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.AttachedPhotoDto;
import com.triple.mapper.AttachedPhotoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AttachedPhotoServiceImpl implements AttachedPhotoService {
	
	private final AttachedPhotoMapper attachedPhotoMapper;

	@Override
	@Transactional(readOnly = true)
	public AttachedPhotoDto getPhotoInfo(String photoid) {
		log.info("request - AttachedPhotoService getPhotoInfo - photoId : " + photoid);
		
		return attachedPhotoMapper.getPhotoInfo(photoid);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AttachedPhotoDto> getSpecificAcitivityPhotoInfo(String activityid) {
		log.info("request - AttachedPhotoService getSpecificAcitivityPhotoInfo - activityId : " + activityid);
		
		return attachedPhotoMapper.getSpecificAcitivityPhotoInfo(activityid);
	}
	
	@Override
	@Transactional
	public boolean createPhotoData(AttachedPhotoDto requestDto) {
		log.info("request - AttachedPhotoService getSpecificAcitivityPhotoInfo - activityId : " + requestDto.getAttachedActivityId());
		
		return attachedPhotoMapper.createPhotoData(requestDto) == 1;
	}

}
