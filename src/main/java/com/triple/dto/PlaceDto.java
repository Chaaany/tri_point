package com.triple.dto;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "Place (장소)", description = "장소 정보의 상세 정보를 나타낸다.")
public class PlaceDto {

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "장소 id")
	private String placeId;

	@ApiModelProperty(value = "장소 등록 사용자 id")
	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	private String uploadUserId;

	@ApiModelProperty(value = "장소 등록 일자")
	private String uploadedDate;

	@ApiModelProperty(value = "장소 삭제 여부")
	private int isDeleted;

	@ApiModelProperty(value = "장소 삭제 일자")
	private String deletedDate;

	public PlaceDto(String placeId, String uploadUserId) {
		this.placeId = placeId;
		this.uploadUserId = uploadUserId;
	}

	public PlaceDto(String placeId, String uploadUserId, String uploadedDate, int isDeleted, String deletedDate) {
		this.placeId = placeId;
		this.uploadUserId = uploadUserId;
		this.uploadedDate = uploadedDate;
		this.isDeleted = isDeleted;
		this.deletedDate = deletedDate;
	}

}