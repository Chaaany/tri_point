package com.triple.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	
   //400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(400, "잘못된 파라미터 값 전송"),

    //404 NOT_FOUND 잘못된 리소스 접근
    PLACE_NOT_FOUND(404, "존재하지 않는 장소 ID"),
    USER_NOT_FOUND(404, "존재하지 않는 사용자 ID"),
    REVIEW_NOT_FOUND(404, "존재하지 않는 리뷰 ID"),
    ATTACHED_PHOTO_NOT_FOUND(404, "존재하지 않는 첨부사진 ID"),
    REVIEW_NOT_DELETED(404, "삭제되지 않은 리뷰 ID"),
    ATTACHED_PHOTO_NOT_DELETED(404, "삭제되지 않은 첨부사진 ID"),
    
    REVIEW_INFO_NOT_MATCHED(404, "전송된 정보와 일치 하지 않는 DB상 리뷰 정보"),
    ATTACHED_PHOTO_INFO_NOT_MATCHED(404, "전송된 정보와 일치 하지 않는 DB상 첨부사진 정보"),
    
    

    //409 CONFLICT 중복된 리소스
    POINT_RECORD_ALREADY_EXISTED(409, "이미 저장되어 있는 포인트 ID"),
    ALREADY_SAVED_FAIR(409, "이미 저장한 박람회입니다."),
    ALREADY_SAVED_FESTIVAL(409, "이미 저장한 페스티벌입니다."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다. 서버 팀에 연락주세요!");
    
	
	private final int status;
	private final String message;
	
}
