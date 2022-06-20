package com.triple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.AttachedPhotoDto;
import com.triple.mapper.AttachedPhotoMapper;

@Service
public class AttachedPhotoServiceImpl implements AttachedPhotoService {

	@Autowired
	private AttachedPhotoMapper attachedPhotoMapper;

	@Override
	public List<AttachedPhotoDto> getAllPhoto() throws Exception {
		return attachedPhotoMapper.getAllPhoto();
	}

	@Override
	@Transactional
	public boolean uploadPhoto(AttachedPhotoDto photodto) throws Exception {
		return attachedPhotoMapper.uploadPhoto(photodto) == 1;
	}

	@Override
	public AttachedPhotoDto photoInfo(String photoid) throws Exception {
		return attachedPhotoMapper.photoInfo(photoid);
	}

	@Override
	@Transactional
	public boolean updatePhoto(AttachedPhotoDto photodto) throws Exception {
		return attachedPhotoMapper.updatePhoto(photodto) == 1;
	}

	@Override
	@Transactional
	public boolean deletePhoto(String photoid) throws Exception {
		return attachedPhotoMapper.deletePhoto(photoid) == 1;
	}

}
