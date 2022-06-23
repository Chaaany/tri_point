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
@ApiModel(value = "Point (포인트)", description = "포인트 정보의 상세 정보를 나타낸다.")
public class PointDto {
	@ApiModelProperty(value = "포인트 테이블 id")
	private int pointId;
	@ApiModelProperty(value = "사용자 id")
	private String userId;
	@ApiModelProperty(value = "포인트 적립/차감 Event 종류(첫 리뷰 작성, 1자 이상 내용 작성, 첨부 사진 1개 이상 등")
	private int activityType;
	@ApiModelProperty(value = "Event 발생시킨 activity의 id")
	private String activityId;
	@ApiModelProperty(value = "포인트 점수")
	private int pointScore;
	@ApiModelProperty(value = "포인트 적립/차감 Type 종류(basic, bonus 등)")
	private int pointType;
	@ApiModelProperty(value = "포인트 데이터 생성 일자")
	private String createdDate;

	public PointDto(String userId, int pointScore) {
		this.userId = userId;
		this.pointScore = pointScore;
	}

	public PointDto(String userId, int activityType, String activityId, int pointScore, int pointType) {
		this.userId = userId;
		this.activityType = activityType;
		this.activityId = activityId;
		this.pointScore = pointScore;
		this.pointType = pointType;
	}


}