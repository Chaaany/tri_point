package com.triple.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "AttachedPhoto (첨부사진파일정보)", description = "첨부된 사진파일의 상세 정보를 나타낸다.")
public class AttachedPhotoDto {

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "첨부된 사진파일 ID")
	private String attachedPhotoId;

	@Pattern(regexp = "^[0-9]{9}$")
	@ApiModelProperty(value = "사진 파일 업로드된 활동 종류")
	private int attachedActivityType;

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "사진 파일 업로드 활동 Id")
	private String attachedActivityId;

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
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

	public AttachedPhotoDto(String attachedPhotoId, int attachedActivityType, String attachedActivityId,
			String uploadUserId) {
		this.attachedPhotoId = attachedPhotoId;
		this.attachedActivityType = attachedActivityType;
		this.attachedActivityId = attachedActivityId;
		this.uploadUserId = uploadUserId;
	}

	public AttachedPhotoDto(String attachedPhotoId, int attachedActivityType, String attachedActivityId,
			String uploadUserId, String uploadedDate, int isDeleted, String deletedDate) {
		this.attachedPhotoId = attachedPhotoId;
		this.attachedActivityType = attachedActivityType;
		this.attachedActivityId = attachedActivityId;
		this.uploadUserId = uploadUserId;
		this.uploadedDate = uploadedDate;
		this.isDeleted = isDeleted;
		this.deletedDate = deletedDate;
	}

}
