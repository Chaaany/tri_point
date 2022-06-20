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
	private String reviewedDate;
	@ApiModelProperty(value = "리뷰 수정 일자")
	private String modifiedDate;
	@ApiModelProperty(value = "리뷰 삭제 일자")
	private String deletedDate;
	@ApiModelProperty(value = "사진 첨부 갯수")
	private int attachedPhotoCount;

	public ReviewDto(String reviewId, String placeId, String userId, String content, int isDeleted, String reviewedDate,
			String modifiedDate, String deletedDate, int attachedPhotoCount) {
		this.reviewId = reviewId;
		this.placeId = placeId;
		this.userId = userId;
		this.content = content;
		this.isDeleted = isDeleted;
		this.reviewedDate = reviewedDate;
		this.modifiedDate = modifiedDate;
		this.deletedDate = deletedDate;
		this.attachedPhotoCount = attachedPhotoCount;
	}



	public ReviewDto(String reviewId, String placeId, String userId, String content, int attachedPhotoCount) {
		this.reviewId = reviewId;
		this.placeId = placeId;
		this.userId = userId;
		this.content = content;
		this.attachedPhotoCount = attachedPhotoCount;
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



	public int getIsDeleted() {
		return isDeleted;
	}



	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}



	public String getReviewedDate() {
		return reviewedDate;
	}



	public void setReviewedDate(String reviewedDate) {
		this.reviewedDate = reviewedDate;
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



	public int getAttachedPhotoCount() {
		return attachedPhotoCount;
	}



	public void setAttachedPhotoCount(int attachedPhotoCount) {
		this.attachedPhotoCount = attachedPhotoCount;
	}



	@Override
	public String toString() {
		return "ReviewDto [reviewId=" + reviewId + ", placeId=" + placeId + ", userId=" + userId + ", content="
				+ content + ", isDeleted=" + isDeleted + ", reviewedDate=" + reviewedDate + ", modifiedDate="
				+ modifiedDate + ", deletedDate=" + deletedDate + ", attachedPhotoCount=" + attachedPhotoCount + "]";
	}




}