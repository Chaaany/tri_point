package com.triple.dto;

import java.util.List;

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
@ApiModel(value = "ReviewEventRequest (리뷰 event 관련 정보)", description = "Review와 관련된 event 발생 시 전달 받은 상세 정보를 나타낸다.")
public class ReviewEventRequestDto {

	@ApiModelProperty(value = "미리 정의된 string 값을 가지고 있습니다. 리뷰 이벤트의 경우 \"REVIEW\" 로 옵니다.")
	private String type;
	@ApiModelProperty(value = " 리뷰 생성 이벤트의 경우 \"ADD\" , 수정 이벤트는 \"MOD\" , 삭제 이벤트는 \"DELETE\" 값을 가지고 있습니다.")
	private String action;
	@ApiModelProperty(value = "UUID 포맷의 review id입니다. 어떤 리뷰에 대한 이벤트인지 가리키는 값입니다.")
	private String reviewId;
	@ApiModelProperty(value = "리뷰의 내용입니다.")
	private String content;
	@ApiModelProperty(value = "리뷰에 첨부된 이미지들의 id 배열입니다.")
	private List<String> attachedPhotoIds;
	@ApiModelProperty(value = "리뷰의 작성자 id입니다")
	private String userId;
	@ApiModelProperty(value = "리뷰가 작성된 장소의 id입니다.")
	private String placeId;

	// "DELETE" Constructor
	public ReviewEventRequestDto(String type, String action, String reviewId, String userId) {
		this.type = type;
		this.action = action;
		this.reviewId = reviewId;
		this.userId = userId;
	}

}
