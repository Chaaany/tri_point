package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.UserDto;

public interface UserMapper {
	
	public List<UserDto> getAllUserInfo() throws SQLException;
	
	public UserDto getUserInfo(String userid) throws SQLException;

	public int createUserData(UserDto requestDto) throws SQLException;

}