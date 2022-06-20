package com.triple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.PointDto;
import com.triple.mapper.PointMapper;

@Service
public class PointServiceImpl implements PointService {

	@Autowired
	private PointMapper pointMapper;

	@Override
	public List<PointDto> getAllPoint() throws Exception {
		return pointMapper.getAllPoint();
	}

	@Override
	@Transactional
	public boolean plusPoint(PointDto pointdto) throws Exception {
		return pointMapper.plusPoint(pointdto) == 1;
	}

	@Override
	@Transactional
	public boolean minusPoint(PointDto pointdto) throws Exception {
		return pointMapper.minusPoint(pointdto) == 1;
	}

	@Override
	public PointDto pointInfo(String pointid) throws Exception {
		return pointMapper.pointInfo(pointid);
	}

	@Override
	@Transactional
	public boolean updatePoint(PointDto pointdto) throws Exception {
		return pointMapper.updatePoint(pointdto) == 1;
	}

	@Override
	@Transactional
	public boolean deletePoint(String pointid) throws Exception {
		return pointMapper.deletePoint(pointid) == 1;
	}

}
