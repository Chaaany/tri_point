package com.triple.mapper;

import java.util.List;

import com.triple.dto.UserDto;

public interface UserMapper {
	
	public List<UserDto> getAllUserInfo();
	
	public UserDto getUserInfo(String userid);

	public int createUserData(UserDto requestDto);

}