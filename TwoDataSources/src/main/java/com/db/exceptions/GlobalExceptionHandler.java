package com.db.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<Object> productNotFound(UserNotFound exc)
	{
		return new ResponseEntity<Object>("user Not Found for "+exc.getLocalizedMessage(), HttpStatus.NOT_FOUND);
	}

}
