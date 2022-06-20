package com.triple.service;

import java.util.List;

import com.triple.dto.PointDto;

public interface PointService {

	public List<PointDto> getAllPoint() throws Exception;
	
	public boolean plusPoint(PointDto pointdto) throws Exception;
	
	public boolean minusPoint(PointDto pointdto) throws Exception;
	
	public PointDto pointInfo(String pointid) throws Exception;
	
	public boolean updatePoint(PointDto pointdto) throws Exception;

	public boolean deletePoint(String pointid) throws Exception;

}
