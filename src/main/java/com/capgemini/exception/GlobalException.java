package com.capgemini.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value =  Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = MechanicsException.class)
	public ResponseEntity<String> handleMechanicsException(MechanicsException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
