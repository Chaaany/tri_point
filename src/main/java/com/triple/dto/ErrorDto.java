package com.triple.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ErrorDto (에러 관련 정보)", description = "Error code 정보를 전달해 준다.")
public class ErrorDto {

	@ApiModelProperty(value = "첨부된 사진파일 ID")
	private int status;
	@ApiModelProperty(value = "사진 파일 업로드된 활동 종류")
	private String message;
	
	public ErrorDto(int status, String message) {
		this.status = status;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
