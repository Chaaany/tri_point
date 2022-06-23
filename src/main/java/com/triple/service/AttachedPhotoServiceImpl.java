package com.triple.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.controller.MainController;
import com.triple.dto.AttachedPhotoDto;
import com.triple.mapper.AttachedPhotoMapper;

@Service
public class AttachedPhotoServiceImpl implements AttachedPhotoService {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private AttachedPhotoMapper attachedPhotoMapper;

	@Override
	public AttachedPhotoDto getPhotoInfo(String photoid) {
		try {
			return attachedPhotoMapper.getPhotoInfo(photoid);
		} catch (Exception e) {
			logger.debug("photo info error");
			return null;
		}
	}

	@Override
	public List<AttachedPhotoDto> getSpecificAcitivityPhotoInfo(String activityId) {
		try {
			return attachedPhotoMapper.getSpecificAcitivityPhotoInfo(activityId);
		}catch (Exception e) {
			logger.debug("get place photo info error");
			return null;
		}
	}
	
	@Override
	@Transactional
	public boolean createPhotoData(AttachedPhotoDto requestDto) {
		try {
			return attachedPhotoMapper.createPhotoData(requestDto) == 1;
		}catch (Exception e) {
			logger.debug("get place photo info error");
			return false;
		}
	}

}
