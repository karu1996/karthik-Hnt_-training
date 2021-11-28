package com.flightApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApplication.entities.AirlineBooking;
import com.flightApplication.entities.Schedule;
import com.flightApplication.exception.AirLineAlreadyExistException;
import com.flightApplication.exception.FlightAlreadyScheduledException;
import com.flightApplication.repo.AirlineBookingRepository;
import com.flightApplication.repo.AirlineScheduleRepository;

@Service
public class AirlineBookingService {

	@Autowired
	private AirlineBookingRepository airlinerepository;
	@Autowired
	private AirlineScheduleRepository airlineScheduleRepo;

	public List<AirlineBooking> getAirline() {
		return airlinerepository.findAll();
	}

	public boolean addNewAirline(AirlineBooking airlinebooking) throws AirLineAlreadyExistException {
		AirlineBooking airlineEntities = new AirlineBooking(airlinebooking.getAirlineName(),airlinebooking.getContactAddr(),
				airlinebooking.getContactName(), airlinebooking.getUploadLogo());

		boolean isExist = airlinerepository.existsByairlineName(airlinebooking.getAirlineName());
		if (isExist)
			throw new AirLineAlreadyExistException(
					"Airline :" + airlinebooking.getAirlineName() + " is already updated on the system");

		AirlineBooking saveedAirLineData = airlinerepository.save(airlineEntities);
		return saveedAirLineData != null;
	}

	public boolean createSchedule(Schedule airlineschedule) throws FlightAlreadyScheduledException {
		Schedule schedule = new Schedule(airlineschedule.getAirline(), airlineschedule.getFromPlace(),
				airlineschedule.getToPlace(), airlineschedule.getStartDateTime(), airlineschedule.getEndDateTime(),
				airlineschedule.getScheduleDay(), airlineschedule.getInstrumentUsed(),
				airlineschedule.getNoOfBusiClassSeat(), airlineschedule.getNoOfNonBusiClassSeat(),
				airlineschedule.getTicketCost(), airlineschedule.getNoOfRows(), airlineschedule.getMeal());

		boolean isExist = airlineScheduleRepo.existsByflightNo(airlineschedule.getFlightNo());
		if (isExist)
			throw new FlightAlreadyScheduledException(
					"Airline :" + airlineschedule.getFlightNo() + " is already updated on the system");

		Schedule saveedAirLineData = airlineScheduleRepo.save(schedule);
		return saveedAirLineData != null;
	}
}
