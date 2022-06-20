package com.triple.mapper;

import java.sql.SQLException;
import java.util.List;

import com.triple.dto.UserDto;

public interface UserMapper {
	
	public List<UserDto> getAllUser() throws SQLException;
	
	public int registerUser(UserDto userdto) throws SQLException;
	
	public UserDto userInfo(String userid) throws SQLException;
	
	public int updateUser(UserDto userdto) throws SQLException;

	public int deleteUser(String userid) throws SQLException;


}