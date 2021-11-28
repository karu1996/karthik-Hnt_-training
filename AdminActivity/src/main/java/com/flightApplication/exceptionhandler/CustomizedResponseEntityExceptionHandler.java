package com.flightApplication.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flightApplication.exception.AirLineAlreadyExistException;
import com.flightApplication.exception.CustomExceptionResponse;
import com.flightApplication.exception.FlightAlreadyScheduledException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
	
	@ExceptionHandler(AirLineAlreadyExistException.class)
	public final ResponseEntity<CustomExceptionResponse> handleAirlineAlreadyExist(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Airline Already Present ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FlightAlreadyScheduledException.class)
	public final ResponseEntity<CustomExceptionResponse> handleFlightAlreadyScheduledException(Exception e, WebRequest ex) {
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), 500, e.getMessage(),
				"Server Error : Flight Already Scheduled Exception ", ex.getDescription(false), e);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
