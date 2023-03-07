package com.example.Student.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<BusinessExceptionInfoGettersAndSetters> handleBusinessException(BusinessException ex){
		BusinessExceptionInfoGettersAndSetters be = new BusinessExceptionInfoGettersAndSetters();
		be.setError("Internal Error");
		be.setStatus("500");
		be.setMessage(ex.getMessage());		
		be.setTimeStamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK).body(be);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<BusinessExceptionInfoGettersAndSetters> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		BusinessExceptionInfoGettersAndSetters be = new BusinessExceptionInfoGettersAndSetters();
		be.setError("Method not allowed");
		be.setStatus("405");
		be.setMessage(ex.getMessage());
		be.setTimeStamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK).body(be);
	}
}
