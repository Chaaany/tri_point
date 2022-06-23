package com.triple.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.triple.annotation.AttachedPhotoId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "ReviewEventRequest (리뷰 event 관련 정보)", description = "Review와 관련된 event 발생 시 전달 받은 상세 정보를 나타낸다.")
public class ReviewEventRequestDto {

	@NotNull
	@ApiModelProperty(value = "미리 정의된 string 값을 가지고 있습니다. 리뷰 이벤트의 경우 \"REVIEW\" 로 옵니다.")
	private String type;

	@NotNull
	@ApiModelProperty(value = " 리뷰 생성 이벤트의 경우 \"ADD\" , 수정 이벤트는 \"MOD\" , 삭제 이벤트는 \"DELETE\" 값을 가지고 있습니다.")
	private String action;

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "UUID 포맷의 review id입니다. 어떤 리뷰에 대한 이벤트인지 가리키는 값입니다.")
	private String reviewId;

	@NotNull
	@ApiModelProperty(value = "리뷰의 내용입니다.")
	private String content;

	@AttachedPhotoId
	@ApiModelProperty(value = "리뷰에 첨부된 이미지들의 id 배열입니다.")
	private List<String> attachedPhotoIds;

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "리뷰의 작성자 id입니다")
	private String userId;

	@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$")
	@ApiModelProperty(value = "리뷰가 작성된 장소의 id입니다.")
	private String placeId;

	// "DELETE" Constructor
	public ReviewEventRequestDto(String type, String action, String reviewId, String userId) {
		this.type = type;
		this.action = action;
		this.reviewId = reviewId;
		this.userId = userId;
	}
	
	// "ADD", "MOD" Constructor
	public ReviewEventRequestDto(@NotNull String type, @NotNull String action, String reviewId, String content,
			List<String> attachedPhotoIds, String userId, String placeId) {
		this.type = type;
		this.action = action;
		this.reviewId = reviewId;
		this.content = content;
		this.attachedPhotoIds = attachedPhotoIds;
		this.userId = userId;
		this.placeId = placeId;
	}

}
