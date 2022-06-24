package com.triple.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.triple.constants.ErrorCode.PLACE_RECORD_ALREADY_EXISTED;
import com.triple.dto.PlaceDto;
import com.triple.exception.CustomException;
import com.triple.mapper.PlaceMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

	private final PlaceMapper placeMapper;

	@Override
	@Transactional(readOnly = true)
	public PlaceDto getPlaceInfo(String placeid) {
		log.info("request - PlaceService getPlaceInfo - placeId : " + placeid);
		
		return placeMapper.getPlaceInfo(placeid);
	}

	@Override
	@Transactional
	public boolean createPlaceData(PlaceDto requestDto) {
		log.info("request - PlaceService createPlaceData - placeId : " + requestDto.getPlaceId());
		
		if(placeMapper.getPlaceInfo(requestDto.getPlaceId())!= null) throw new CustomException(PLACE_RECORD_ALREADY_EXISTED);
		
		return placeMapper.createPlaceData(requestDto) == 1;
	}
	
}
