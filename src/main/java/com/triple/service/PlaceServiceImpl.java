package com.triple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.PlaceDto;
import com.triple.mapper.PlaceMapper;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceMapper placeMapper;

	@Override
	public List<PlaceDto> getAllPlace() throws Exception {
		return placeMapper.getAllPlace();
	}

	@Override
	@Transactional
	public boolean uploadPlace(PlaceDto placedto) throws Exception {
		return placeMapper.uploadPlace(placedto) == 1;
	}

	@Override
	public PlaceDto placeInfo(String placeid) throws Exception {
		return placeMapper.placeInfo(placeid);
	}

	@Override
	@Transactional
	public boolean updatePlace(PlaceDto placeadto) throws Exception {
		return placeMapper.updatePlace(placeadto) == 1;
	}

	@Override
	@Transactional
	public boolean deletePlace(String placeid) throws Exception {
		return placeMapper.deletePlace(placeid) == 1;
	}



}
