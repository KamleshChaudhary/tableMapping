package com.example.demo.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import com.example.demo.model.studentNotFoundException;

@ControllerAdvice
@RestController
public class Customize extends ResponseEntityExceptionHandler {
    
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
	  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
	      
	    return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
	    		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
		 ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(), ((MethodArgumentNotValidException) request).getBindingResult().toString());
	      
		    return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
		
	}
	
}
 