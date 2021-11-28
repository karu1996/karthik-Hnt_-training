package com.flightApplication.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApplication.entities.Flight;
import com.flightApplication.exceptions.PnrNumberNotFoundException;
import com.flightApplication.repo.FlightRepository;

@Service
public class FlightBookingService {

	@Autowired
	private FlightRepository flightRepository;

	public List<Flight> getFlights() {
		return flightRepository.findAll();
	}

	public Flight getFlightByPNR(int pnr) throws PnrNumberNotFoundException {
		
		Optional<Flight> optional = flightRepository.findById(pnr);
		System.out.println("pnr  " +pnr);
		System.out.println("optional  " + optional);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new PnrNumberNotFoundException("The PNR " + pnr + " not found");
		}

	}

	public List<Flight> getFlightByEmail(String emailId) {

		return flightRepository.findByEmailId(emailId);
	}

	public Flight bookTicket(Flight flight) {
		int pnr = generatePNRNumber();
		flight = new Flight(flight.getFlightNo(),pnr, flight.getName(), flight.getEmailId(), flight.getNumOfSeatsToBook(),
				flight.getPassengerName(), flight.getPassengerGender(), flight.getPassengerAge(), flight.getMealType(),
				flight.getSeaNum());
		return flightRepository.save(flight);
	}

	public int generatePNRNumber() {
		Random random = new Random();
        int rand = random.nextInt();
		return rand;
	}

	public Flight updateTicket(int pnr, Flight flight) throws PnrNumberNotFoundException {
		flight.setPnrNo(pnr);
		if (flightRepository.existsById(pnr)) {
			return flightRepository.save(flight);
		} else {
			throw new PnrNumberNotFoundException();
		}
	}

	public Flight cancelTicket(int pnr) throws PnrNumberNotFoundException {
		try {
			Flight flight = getFlightByPNR(pnr);
			flightRepository.delete(flight);
			return flight;
		} catch (NullPointerException e) {
			throw new PnrNumberNotFoundException();
		}
	}
}
