package com.order.management.orderservice.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	    
		private HttpStatus status;
	    private String message;
	    private List<String> details;
	    
		public ErrorResponse(HttpStatus status, String message, String details) {
			super();
			this.status = status;
			this.message = message;
			this.details = Arrays.asList(details);
		}
	}
