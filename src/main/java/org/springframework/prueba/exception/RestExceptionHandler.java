package org.springframework.prueba.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Petición JSON mal formada.";
		return buildResponseEntity(new APIError(HttpStatus.BAD_REQUEST, error, ex));

	}

	private ResponseEntity<Object> buildResponseEntity(APIError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	protected ResponseEntity<Object> handleEmptyResultDataAccess(
			EmptyResultDataAccessException ex){
		APIError apiError = new APIError(HttpStatus.NO_CONTENT);
		return buildResponseEntity(apiError); 
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(
			Exception ex){
		APIError apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR); 
		apiError.setMessage("Error inesperado: "+ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(DataAccessException.class)
	protected ResponseEntity<Object> handeDataAccessException(
			DataAccessException ex){
		APIError apiError = new APIError(HttpStatus.BAD_REQUEST); 
		apiError.setMessage("Llave única duplicada");
		return buildResponseEntity(apiError);
	}
	
	
}
