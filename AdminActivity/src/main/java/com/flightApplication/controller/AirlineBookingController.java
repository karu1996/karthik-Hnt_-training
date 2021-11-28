package com.flightApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.entities.AirlineBooking;
import com.flightApplication.entities.Schedule;
import com.flightApplication.exception.AirLineAlreadyExistException;
import com.flightApplication.exception.FlightAlreadyScheduledException;
import com.flightApplication.service.AirlineBookingService;


@RestController
public class AirlineBookingController {

	@Autowired
	private AirlineBookingService airlineService;
	
	
	@GetMapping("airline/getairline")
	public List<AirlineBooking> getAllAirline()
	{
		return airlineService.getAirline();
	}
	
	@PostMapping("/airline/register")   
	public boolean bookNewAirline(@RequestBody AirlineBooking airlinebooking) throws AirLineAlreadyExistException
	{
		return airlineService.addNewAirline(airlinebooking);
	}
	
	@PostMapping("/airline/add")  
	public boolean createSchedule(@RequestBody Schedule schedule) throws FlightAlreadyScheduledException
	{
		return airlineService.createSchedule(schedule);
	}
}
