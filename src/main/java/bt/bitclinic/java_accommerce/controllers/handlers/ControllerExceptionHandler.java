package bt.bitclinic.java_accommerce.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import bt.bitclinic.java_accommerce.dto.CustomError;
import bt.bitclinic.java_accommerce.exceptions.DatabaseException;
import bt.bitclinic.java_accommerce.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) 
	{
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) 
	{
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomError> validation(MethodArgumentNotValidException e, HttpServletRequest request) 
	{
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
}