package com.triple.exception;

import static com.triple.constants.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.triple.constants.ErrorCode.INVALID_PARAMETER;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.triple.dto.ErrorDto;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobolExceptionHandler {

	// Custom Exception Handler
	@ExceptionHandler({ CustomException.class })
	protected ResponseEntity<ErrorDto> handleCustomException(CustomException e) {
		log.error("error : " + e.getErrorCode().getMessage());
		e.printStackTrace();

		return new ResponseEntity<ErrorDto>(new ErrorDto(e.getErrorCode().getStatus(), e.getErrorCode().getMessage()),
				HttpStatus.valueOf(e.getErrorCode().getStatus()));
	}

	// Server Error or Undefined Exception Handler
	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<ErrorDto> handleServerException(Exception e) {
		log.error("Server error : " + e.getMessage());
		e.printStackTrace();

		return new ResponseEntity<ErrorDto>(
				new ErrorDto(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// @Valid : Dto validation Exception
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ErrorDto> processValidationError(MethodArgumentNotValidException e) {
		log.error("error : " + e.getMessage());
		e.printStackTrace();

		return new ResponseEntity<ErrorDto>(new ErrorDto(INVALID_PARAMETER.getStatus(), INVALID_PARAMETER.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

}
