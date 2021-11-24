package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Ticket;
import com.flightapp.models.AvailableSchedule;
import com.flightapp.models.FlightTicket;
import com.flightapp.models.SearchRequest;
import com.flightapp.userservices.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
		
	@PostMapping("/ticket/search")
	public List<AvailableSchedule> searchTicket(@RequestBody SearchRequest request ) {
		return userService.searchTicket(request);
	}
	
	@PostMapping("/ticket/book")
	public FlightTicket bookTicket(@RequestBody FlightTicket ticket ) {
		return userService.bookTicket(ticket);
	}
	
	@PutMapping("/ticket/cancel")
	public FlightTicket cancelTicket(@RequestBody FlightTicket ticket ) {
		return userService.cancelTicket(ticket);
	}
	
	@GetMapping("/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable String ticketId ) {
		return userService.getTicketById(Long.valueOf(ticketId));
	}
	
	@GetMapping("/ticket/email/{email}")
	public Ticket getTicketByEmail(@PathVariable String email ) {
		return userService.getTicketByEmail(email);
	}
	
}
