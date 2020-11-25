package com.order.management.orderservice.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler  {
	
	
	    @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Server Error", details);
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	    @ExceptionHandler(RecordNotFoundException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND,"Record Not Found", details);
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
	 
	   
	    @Override
	    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, 
	      HttpHeaders headers, 
	      HttpStatus status, 
	      WebRequest request) {
	        String error = ex.getMethod() + " method is not supported for this request. Supported methods are "+
	        ex.getSupportedHttpMethods();
	     
	        ErrorResponse apiError = new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED,ex.getLocalizedMessage(), error);
	        return new ResponseEntity<>(apiError, HttpStatus.METHOD_NOT_ALLOWED);
	    }
	}

