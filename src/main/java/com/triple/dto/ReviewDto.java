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
	private String uploadedDate;
	@ApiModelProperty(value = "리뷰 수정 일자")
	private String modifiedDate;
	@ApiModelProperty(value = "리뷰 삭제 일자")
	private String deletedDate;

}