package com.triple.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "Review (리뷰)", description = "장소에 대한 리뷰 정보의 상세 정보를 나타낸다.")
public class ReviewDto {
	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "리뷰 id")
	private String reviewId;

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "장소 id")
	private String placeId;

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "리뷰 작성자 id")
	private String userId;

	@NotNull
	@ApiModelProperty(value = "리뷰 내용")
	private String content;

	@ApiModelProperty(value = "리뷰 삭제 여부")
	private int isDeleted;

	@ApiModelProperty(value = "리뷰 작성 일자")
	private String uploadedDate;

	@ApiModelProperty(value = "리뷰 수정 일자")
	private String modifiedDate;

	@ApiModelProperty(value = "리뷰 삭제 일자")
	private String deletedDate;

	public ReviewDto(String reviewId, String placeId, String userId, String content) {
		this.reviewId = reviewId;
		this.placeId = placeId;
		this.userId = userId;
		this.content = content;
	}

	public ReviewDto(String reviewId, String placeId, String userId, String content, int isDeleted, String uploadedDate,
			String modifiedDate, String deletedDate) {
		this.reviewId = reviewId;
		this.placeId = placeId;
		this.userId = userId;
		this.content = content;
		this.isDeleted = isDeleted;
		this.uploadedDate = uploadedDate;
		this.modifiedDate = modifiedDate;
		this.deletedDate = deletedDate;
	}

}