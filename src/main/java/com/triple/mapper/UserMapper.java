package com.triple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.triple.dto.UserDto;

@Mapper
public interface UserMapper {
	
	public List<UserDto> getAllUserInfo();
	
	public UserDto getUserInfo(String userid);

	public int createUserData(UserDto requestDto);

}