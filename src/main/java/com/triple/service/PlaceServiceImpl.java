package com.triple.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triple.controller.MainController;
import com.triple.dto.PlaceDto;
import com.triple.mapper.PlaceMapper;

@Service
public class PlaceServiceImpl implements PlaceService {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private PlaceMapper placeMapper;

	@Override
	public PlaceDto getPlaceInfo(String placeid) {
		try {
			return placeMapper.getPlaceInfo(placeid);
		} catch (Exception e) {
			logger.debug("place info error");
			return null;
		}
	}
}
