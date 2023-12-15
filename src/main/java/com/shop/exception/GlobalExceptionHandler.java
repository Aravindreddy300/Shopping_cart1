package com.shop.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
 
@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(EmployeeNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(CustomerNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(StockNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CartItemNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(CartItemNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(OrderNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ProductNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}