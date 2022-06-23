package com.triple.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.controller.MainController;
import com.triple.dto.UserDto;
import com.triple.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Override
	public List<UserDto> getAllUserInfo() {
		try {
			return userMapper.getAllUserInfo();
		} catch (Exception e) {
			logger.debug("get all user info error");
			return null;
		}
	}

	@Override
	public UserDto getUserInfo(String userid) {
		try {
			return userMapper.getUserInfo(userid);
		} catch (Exception e) {
			logger.debug("get user info error");
			return null;
		}
	}

	@Override
	@Transactional
	public boolean createUserData(UserDto requestDto) {
		try {
			return userMapper.createUserData(requestDto) == 1;
		} catch (Exception e) {
			logger.debug("user data create error");
			return false;
		}
	}

}
