package com.triple.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Review (리뷰)", description = "여행지에 대한 리뷰 정보의 상세 정보를 나타낸다.")
public class ReviewDto {
	@ApiModelProperty(value = "리뷰 id")
	private String reviewId;
	@ApiModelProperty(value = "장소 id")
	private String placeId;
	@ApiModelProperty(value = "리뷰 작성자 id")
	private String userId;
	@ApiModelProperty(value = "리뷰 내용")
	private String content;
	@ApiModelProperty(value = "리뷰 삭제 여부")
	private int isDeleted;
	@ApiModelProperty(value = "리뷰 작성 일자")
	private String uploadDate;
	@ApiModelProperty(value = "리뷰 수정 일자")
	private String modifiedDate;
	@ApiModelProperty(value = "리뷰 삭제 일자")
	private String deletedDate;
	public ReviewDto(String reviewId, String placeId, String userId, String content, int isDeleted, String uploadDate,
			String modifiedDate, String deletedDate) {
		super();
		this.reviewId = reviewId;
		this.placeId = placeId;
		this.userId = userId;
		this.content = content;
		this.isDeleted = isDeleted;
		this.uploadDate = uploadDate;
		this.modifiedDate = modifiedDate;
		this.deletedDate = deletedDate;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean getIsDeleted() {
		return isDeleted == 1;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getDeletedDate() {
		return deletedDate;
	}
	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}
	@Override
	public String toString() {
		return "ReviewDto [reviewId=" + reviewId + ", placeId=" + placeId + ", userId=" + userId + ", content="
				+ content + ", isDeleted=" + isDeleted + ", uploadDate=" + uploadDate + ", modifiedDate=" + modifiedDate
				+ ", deletedDate=" + deletedDate + "]";
	}

	
}