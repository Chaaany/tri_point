package com.triple.exception;

import static com.triple.constants.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.triple.constants.ErrorCode.INVALID_PARAMETER;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.triple.dto.ErrorDto;

@RestControllerAdvice
public class GlobolExceptionHandler {
	
	// Custom Exception Handler
    @ExceptionHandler({ CustomException.class })
    protected ResponseEntity<ErrorDto> handleCustomException(CustomException ex) {
    	logger
        return new ResponseEntity<ErrorDto>(new ErrorDto(ex.getErrorCode().getStatus(), ex.getErrorCode().getMessage()), HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }
    
    // Server Error or Undefined Exception Handler
    @ExceptionHandler({ Exception.class })
    protected ResponseEntity<ErrorDto> handleServerException(Exception ex) {
        return new ResponseEntity<ErrorDto>(new ErrorDto(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //@Valid : Dto validation Exception
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> processValidationError(MethodArgumentNotValidException ex) {
        return new ResponseEntity<ErrorDto>(new ErrorDto(INVALID_PARAMETER.getStatus(), INVALID_PARAMETER.getMessage()), HttpStatus.BAD_REQUEST);
    }
    
    
}
