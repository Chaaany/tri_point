package com.triple.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.UserDto;
import com.triple.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	
	@Override
	public List<UserDto> getAllUserInfo() {
		log.info("request - UserService getAllUserInfo");
		
		return userMapper.getAllUserInfo();
	}

	@Override
	public UserDto getUserInfo(String userid) {  
		log.info("request - UserService getUserInfo userId : " + userid);
		
		return userMapper.getUserInfo(userid);
	}

	@Override
	@Transactional
	public boolean createUserData(UserDto requestDto) {
		log.info("request - UserService createUserData userId : " + requestDto.getUserId());
		
		return userMapper.createUserData(requestDto) == 1;
	}

}
