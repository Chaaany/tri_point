package com.triple.service;

import java.util.List;

import com.triple.dto.UserDto;

public interface UserService {

	public List<UserDto> getAllUser() throws Exception;

	public boolean registerUser(UserDto userdto) throws Exception;

	public UserDto userInfo(String userid) throws Exception;

	public boolean updateUser(UserDto userdto) throws Exception;

	public boolean deleteUser(String userid) throws Exception;

}
