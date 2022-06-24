package com.triple.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;

import com.triple.dto.UserDto;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	@DisplayName("사용자 ID로 사용자 정보 상세 조회")
	void testGetUserInfo() {
		// given
		String existedUserid = "3ede0ef2-92b7-4817-a5f3-0c575361f745"; // DB상 존재하는 id
		String notExistedUserid = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		// when
		UserDto existedUser = userService.getUserInfo(existedUserid);
		UserDto notExistedUser = userService.getUserInfo(notExistedUserid);

		// then
		assertThat(existedUser, is(notNullValue()));
		assertThat(notExistedUser, is(nullValue()));
	}

	@Test
	@DisplayName("사용자 정보 생성")
	void testCreateUserData() {
		// given
		String existedUserid = "3ede0ef2-92b7-4817-a5f3-0c575361f745"; // DB상 존재하는 id
		String notExistedUserid = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		UserDto existedUserDto = new UserDto(existedUserid, "Ben", "1111", 0);
		UserDto notExistedUserDto = new UserDto(notExistedUserid, "triple" + (int) (Math.random() * 10000),
				"" + (int) (Math.random() * 10000), (int) (Math.random() * 2));

		// when
		boolean notExistedUser = userService.createUserData(notExistedUserDto);

		// then
		assertThatThrownBy(() -> userService.createUserData(existedUserDto));
		assertThat(notExistedUser).isTrue();
	}
	
}
