package com.triple.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.triple.constants.ErrorCode.USER_RECORD_ALREADY_EXISTED;
import com.triple.dto.UserDto;
import com.triple.exception.CustomException;
import com.triple.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	
	@Override
	@Transactional(readOnly = true)
	public UserDto getUserInfo(String userid) {  
		log.info("request - UserService getUserInfo userId : " + userid);
		
		return userMapper.getUserInfo(userid);
	}

	@Override
	@Transactional
	public boolean createUserData(UserDto requestDto) {
		log.info("request - UserService createUserData userId : " + requestDto.getUserId());
		
		if(userMapper.getUserInfo(requestDto.getUserId()) != null) 
			throw new CustomException(USER_RECORD_ALREADY_EXISTED);
		
		return userMapper.createUserData(requestDto) == 1;
	}

}
