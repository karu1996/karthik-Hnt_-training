package com.flightapp.userserviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightapp.entities.Passenger;
import com.flightapp.entities.Ticket;
import com.flightapp.models.AvailableSchedule;
import com.flightapp.models.FlightTicket;
import com.flightapp.models.SearchRequest;
import com.flightapp.repositories.PassengerRepository;
import com.flightapp.repositories.TicketRepository;
import com.flightapp.userservices.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TicketRepository ticketRepo;
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public FlightTicket bookTicket(FlightTicket ticket) {
	ticket.getTicket().setStatus("Active");
	Ticket ticketSaved = ticketRepo.save(ticket.getTicket());
	List<Passenger> savedPassenger = new ArrayList<>();
	
	ticket.getPassenger().forEach(pass ->{ 
		pass.setTicketId(ticketSaved.getTicketId());
		//need to add logic for booking passenger seat
		Passenger passenger = passengerRepo.save(pass);
		savedPassenger.add(passenger);
	});
	
	FlightTicket bookedTicket = new FlightTicket();
	bookedTicket.setTicket(ticketSaved);
	bookedTicket.setPassenger(savedPassenger);
	return bookedTicket;
	}

	@Override
	public FlightTicket cancelTicket(FlightTicket ticket) {
		FlightTicket cancelledTicket = new FlightTicket();
		Ticket ticketDetails = ticket.getTicket(); 
		ticketDetails.setStatus("Cancelled");
		Ticket flightTicket = ticketRepo.save(ticketDetails);
		cancelledTicket.setTicket(flightTicket);
		cancelledTicket.setPassenger(getPassengerByTicketId(flightTicket.getTicketId()));
		return cancelledTicket;
	}
	
	@Override
	public Ticket getTicketById(long ticketId) {
		return ticketRepo.findById(ticketId).get();
	}

	@Override
	public Ticket getTicketByEmail(String email) {
		return ticketRepo.findByEmail(email);
	}
	
	public List<Passenger> getPassengerByTicketId(long ticketId) {
		return passengerRepo.findByTicketId(ticketId);
	}

	@Override
	public List<AvailableSchedule> searchTicket(SearchRequest request) {
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<SearchRequest> req = new HttpEntity<>(request, requestHeaders);
        ResponseEntity<AvailableSchedule[]> response = restTemplate.postForEntity("http://AIRLINES-SERVICE/searchavailability", req,
        		AvailableSchedule[].class);
		return Arrays.asList(response.getBody());
	}

}
