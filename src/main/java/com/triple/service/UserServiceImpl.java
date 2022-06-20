package com.triple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.dto.UserDto;
import com.triple.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDto> getAllUser() throws Exception {
		return userMapper.getAllUser();
	}

	@Override
	@Transactional
	public boolean registerUser(UserDto userdto) throws Exception {
		return userMapper.registerUser(userdto) == 1;
	}

	@Override
	public UserDto userInfo(String userid) throws Exception {
		return userMapper.userInfo(userid);
	}

	@Override
	@Transactional
	public boolean updateUser(UserDto userdto) throws Exception {
		return userMapper.updateUser(userdto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteUser(String userid) throws Exception {
		return userMapper.deleteUser(userid) == 1;
	}

}
