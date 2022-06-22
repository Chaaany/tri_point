package com.triple.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

	public PlaceDto(String placeId, String uploadUserId, String uploadedDate, int isDeleted, String deletedDate) {
		this.placeId = placeId;
		this.uploadUserId = uploadUserId;
		this.uploadedDate = uploadedDate;
		this.isDeleted = isDeleted;
		this.deletedDate = deletedDate;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
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

	public boolean getIsDeleted() {
		return isDeleted == 1;
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
		return "PlaceDto [placeId=" + placeId + ", uploadUserId=" + uploadUserId + ", uploadedDate=" + uploadedDate
				+ ", isDeleted=" + isDeleted + ", deletedDate=" + deletedDate + "]";
	}

}