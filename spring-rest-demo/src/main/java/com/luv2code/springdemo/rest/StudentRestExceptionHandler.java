package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

		// Dedicated exception handler for the student id
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exec) {
			
			StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
			studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentErrorResponse.setMessage(exec.getMessage());
			studentErrorResponse.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.NOT_FOUND);
		}
		
		// Add a generic exception handler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exec) {
			
			StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
			studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			studentErrorResponse.setMessage(exec.getMessage());
			studentErrorResponse.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.BAD_REQUEST);
		}
}
