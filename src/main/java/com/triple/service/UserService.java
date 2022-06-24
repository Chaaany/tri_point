package com.triple.service;

import com.triple.dto.UserDto;

public interface UserService {

	public UserDto getUserInfo(String userid);

	public boolean createUserData(UserDto requestDto);

}
