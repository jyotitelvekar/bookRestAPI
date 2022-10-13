package com.Example.bookecexception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice // exeption from project and check if it handeled or not
public class GlobleExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handelMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("Time", new Date());
		// ex.getBindingResult().getFieldErrors().forEach(error ->{
		// map.put(error.getField(), error.getDefaultMessage());});
		BindingResult bindingResult = ex.getBindingResult();// it bind data errors
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();// it return field errors to this class
		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());

		}
		return map;
}
	@ExceptionHandler(BookRecordAlreadyExistsExcep.class)
	
	public ResponseEntity<String>bookAlreadyPresent(BookRecordAlreadyExistsExcep ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String>bookNotFoundEx(BookNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}
	
}
