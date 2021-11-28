package com.flightApplication.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flightApplication.advice.CustomExceptionResponse;
import com.flightApplication.exceptions.EmailIDNotFoundException;
import com.flightApplication.exceptions.PnrNumberNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmailIDNotFoundException.class)
	public final ResponseEntity<CustomExceptionResponse> handleAirlineAlreadyExist(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Email ID Not Found Exception", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PnrNumberNotFoundException.class)
	public final ResponseEntity<CustomExceptionResponse> handleFlightAlreadyScheduledException(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : PNR Number Not Found Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
