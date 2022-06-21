package com.triple.service;

import java.util.List;

import com.triple.dto.UserDto;

public interface UserService {

	public List<UserDto> getAllUserInfo();

	public UserDto getUserInfo(String userid);

}
