package com.triple.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AttachedPhoto (첨부사진파일정보)", description = "첨부된 사진파일의 상세 정보를 나타낸다.")
public class AttachedPhotoDto {

	@ApiModelProperty(value = "첨부된 사진파일 ID")
	private String attachedPhotoId;
	@ApiModelProperty(value = "사진 파일 업로드된 활동 종류")
	private int attachedActivityType;
	@ApiModelProperty(value = "사진 파일 업로드 활동 Id")
	private String attachedActivityId;
	@ApiModelProperty(value = "사진 파일 업로드 사용자 Id")
	private String uploadUserId;
	@ApiModelProperty(value = "사진 파일 업로드 일자")
	private String uploadedDate;
	@ApiModelProperty(value = "사진 파일 삭제 여부")
	private int isDeleted;
	@ApiModelProperty(value = "사진 파일 삭제 일자")
	private String deletedDate;

	public AttachedPhotoDto(String attachedPhotoId, int attachedActivityType, String uploadUserId) {
		this.attachedPhotoId = attachedPhotoId;
		this.attachedActivityType = attachedActivityType;
		this.uploadUserId = uploadUserId;
	}
}
