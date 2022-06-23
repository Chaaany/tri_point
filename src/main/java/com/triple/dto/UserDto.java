package com.triple.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "UserDto (회원정보)", description = "회원의 상세 정보를 나타낸다.")
public class UserDto {

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "회원 아이디")
	private String userId;

	@NotBlank
	@ApiModelProperty(value = "회원 닉네임")
	private String nickname;

	@NotBlank
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

	public UserDto(String userId, String nickname, String password, int isRecommendated) {
		this.userId = userId;
		this.nickname = nickname;
		this.password = password;
		this.isRecommendated = isRecommendated;
	}

	public UserDto(String userId, String nickname, String password, String registrationDate,
			String nicknameModifiedDate, int isUnsigned, String unsignedDate, int isRecommendated) {
		this.userId = userId;
		this.nickname = nickname;
		this.password = password;
		this.registrationDate = registrationDate;
		this.nicknameModifiedDate = nicknameModifiedDate;
		this.isUnsigned = isUnsigned;
		this.unsignedDate = unsignedDate;
		this.isRecommendated = isRecommendated;
	}

}
