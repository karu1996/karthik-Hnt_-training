package com.flightApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.entities.Flight;
import com.flightApplication.exceptions.EmailIDNotFoundException;
import com.flightApplication.exceptions.PnrNumberNotFoundException;
import com.flightApplication.service.FlightBookingService;

@RestController
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;
	
	@GetMapping("/ticket")    
	public List<Flight> getFlights(){
		return flightBookingService.getFlights();
	}
	
	@GetMapping("/ticket/{pnr}")  
	public Flight getFlightByPNR(@PathVariable int pnr) throws PnrNumberNotFoundException {
		return flightBookingService.getFlightByPNR(pnr);
	}
	
	@GetMapping("/booking/history/{emailId}")  
	public List<Flight> getFlightByEmail(@PathVariable String emailId) throws EmailIDNotFoundException
	{
		return flightBookingService.getFlightByEmail(emailId);
	}
	
	@PostMapping("/booking/{flightid}")  
	public Flight bookTicket(@RequestBody Flight flight)
	{
		return flightBookingService.bookTicket(flight);
	}
	
	@PutMapping("/booking/{pnr}")  
	public Flight bookTicket(@PathVariable int pnr ,@RequestBody Flight flight) throws PnrNumberNotFoundException
	{
		return flightBookingService.updateTicket(pnr,flight);
	}
	
	@DeleteMapping("/booking/cancel/{pnr}")   
	public Flight cancelTicket(@PathVariable int pnr) throws PnrNumberNotFoundException
	{
		return flightBookingService.cancelTicket(pnr);
	}	
}
