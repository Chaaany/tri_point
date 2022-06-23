package com.triple.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ErrorDto (에러 관련 정보)", description = "Error code 정보를 전달해 준다.")
public class ErrorDto {

	@ApiModelProperty(value = "첨부된 사진파일 ID")
	private int status;
	@ApiModelProperty(value = "사진 파일 업로드된 활동 종류")
	private String message;

}
