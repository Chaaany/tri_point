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
@ApiModel(value = "Place (장소)", description = "장소 정보의 상세 정보를 나타낸다.")
public class PlaceDto {
	@ApiModelProperty(value = "장소 id")
	private String placeId;
	@ApiModelProperty(value = "장소 등록 사용자 id")
	private String uploadUserId;
	@ApiModelProperty(value = "장소 등록 일자")
	private String uploadedDate;
	@ApiModelProperty(value = "사진 파일 삭제 여부")
	private int isDeleted;
	@ApiModelProperty(value = "사진 파일 삭제 일자")
	private String deletedDate;
}