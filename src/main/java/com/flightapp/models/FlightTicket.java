package com.flightapp.models;

import java.util.List;

import com.flightapp.entities.Passenger;
import com.flightapp.entities.Ticket;

public class FlightTicket {

	private Ticket ticket;
	private List<Passenger> passenger;
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	
	public FlightTicket(Ticket ticket, List<Passenger> passenger) {
		super();
		this.ticket = ticket;
		this.passenger = passenger;
	}
	
	public FlightTicket() {}
}
