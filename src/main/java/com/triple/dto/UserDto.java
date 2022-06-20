package com.triple.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
	@ApiModelProperty(value = "누적 포인트")
	private int totalPoint;

	public UserDto(String userId, String nickname, String password, String registrationDate,
			String nicknameModifiedDate, int isUnsigned, String unsignedDate, int isRecommendated, int totalPoint) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.password = password;
		this.registrationDate = registrationDate;
		this.nicknameModifiedDate = nicknameModifiedDate;
		this.isUnsigned = isUnsigned;
		this.unsignedDate = unsignedDate;
		this.isRecommendated = isRecommendated;
		this.totalPoint = totalPoint;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNicknameModifiedDate() {
		return nicknameModifiedDate;
	}

	public void setNicknameModifiedDate(String nicknameModifiedDate) {
		this.nicknameModifiedDate = nicknameModifiedDate;
	}

	public int getIsUnsigned() {
		return isUnsigned;
	}

	public void setIsUnsigned(int isUnsigned) {
		this.isUnsigned = isUnsigned;
	}

	public String getUnsignedDate() {
		return unsignedDate;
	}

	public void setUnsignedDate(String unsignedDate) {
		this.unsignedDate = unsignedDate;
	}

	public int getIsRecommendated() {
		return isRecommendated;
	}

	public void setIsRecommendated(int isRecommendated) {
		this.isRecommendated = isRecommendated;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", nickname=" + nickname + ", password=" + password + ", registrationDate="
				+ registrationDate + ", nicknameModifiedDate=" + nicknameModifiedDate + ", isUnsigned=" + isUnsigned
				+ ", unsignedDate=" + unsignedDate + ", isRecommendated=" + isRecommendated + ", totalPoint="
				+ totalPoint + "]";
	}

}
