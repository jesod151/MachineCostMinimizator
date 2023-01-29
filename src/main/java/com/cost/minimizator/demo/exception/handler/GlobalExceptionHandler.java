package com.cost.minimizator.demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
		ErrorException error = new ErrorException(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

}
