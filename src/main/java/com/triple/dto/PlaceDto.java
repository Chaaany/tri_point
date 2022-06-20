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
	private String uploadDate;
	@ApiModelProperty(value = "리뷰 여부(첫 리뷰 존재 여부)")
	private int reviewCount;

	public PlaceDto(String placeId, String uploadUserId, String uploadDate, int reviewCount) {
		this.placeId = placeId;
		this.uploadUserId = uploadUserId;
		this.uploadDate = uploadDate;
		this.reviewCount = reviewCount;
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

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}


	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "PlaceDto [placeId=" + placeId + ", uploadUserId=" + uploadUserId + ", uploadDate=" + uploadDate
				+ ", isReviewed=" + reviewCount + "]";
	}

}