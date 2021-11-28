package com.flightApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApplication.entities.AirlineBooking;

public interface AirlineBookingRepository extends JpaRepository<AirlineBooking, String> {

	boolean existsByairlineName(String airlineName);


	//public AirlineBooking findByAirlineName(String airlineName);
	
}
