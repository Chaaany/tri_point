package com.triple.exception;

import com.triple.constants.ErrorCode;

public class CustomException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private final ErrorCode errorCode;

	public CustomException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
}
