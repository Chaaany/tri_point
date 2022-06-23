package com.triple.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserDto (회원정보)", description = "회원의 상세 정보를 나타낸다.")
public class UserDto {

	@ApiModelProperty(value = "회원 아이디")
	private String userId;
	@ApiModelProperty(value = "회원 닉네임")
	private String nickname;
	@ApiModelProperty(value = "회원 비밀번호")
	private String password;
	@ApiModelProperty(value = "회원 가입일자")
	private String registrationDate;
	@ApiModelProperty(value = "닉네임 수정일자")
	private String nicknameModifiedDate;
	@ApiModelProperty(value = "회원 탈퇴여부")
	private int isUnsigned;
	@ApiModelProperty(value = "회원 탈퇴일자")
	private String unsignedDate;
	@ApiModelProperty(value = "추천인 여부")
	private int isRecommendated;

}
