package com.triple.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AttachedPhoto (첨부사진파일정보)", description = "첨부된 사진파일의 상세 정보를 나타낸다.")
public class AttachedPhotoDto {

	@ApiModelProperty(value = "첨부된 사진파일 ID")
	private String attachedPhotoId;
	@ApiModelProperty(value = "사진 파일 업로드된 활동 종류")
	private int originType;
	@ApiModelProperty(value = "사진 파일 업로드 사용자 Id")
	private String uploadUserId;
	@ApiModelProperty(value = "사진 파일 업로드 일자")
	private String uploadedDate;
	@ApiModelProperty(value = "사진 파일 삭제 여부")
	private int isDeleted;
	@ApiModelProperty(value = "사진 파일 삭제 일자")
	private String deletedDate;

	public AttachedPhotoDto(String attachedPhotoId, int originType, String uploadUserId, String uploadedDate,
			int isDeleted, String deletedDate) {
		this.attachedPhotoId = attachedPhotoId;
		this.originType = originType;
		this.uploadUserId = uploadUserId;
		this.uploadedDate = uploadedDate;
		this.isDeleted = isDeleted;
		this.deletedDate = deletedDate;
	}

	public AttachedPhotoDto(String attachedPhotoId, int originType, String uploadUserId) {
		this.attachedPhotoId = attachedPhotoId;
		this.originType = originType;
		this.uploadUserId = uploadUserId;
	}

	public String getAttachedPhotoId() {
		return attachedPhotoId;
	}

	public void setAttachedPhotoId(String attachedPhotoId) {
		this.attachedPhotoId = attachedPhotoId;
	}

	public int getOriginType() {
		return originType;
	}

	public void setOriginType(int originType) {
		this.originType = originType;
	}

	public String getUploadUserId() {
		return uploadUserId;
	}

	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

	public String getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Override
	public String toString() {
		return "AttachedPhotoDto [attachedPhotoId=" + attachedPhotoId + ", originType=" + originType + ", uploadUserId="
				+ uploadUserId + ", uploadedDate=" + uploadedDate + ", isDeleted=" + isDeleted + ", deletedDate="
				+ deletedDate + "]";
	}

}
