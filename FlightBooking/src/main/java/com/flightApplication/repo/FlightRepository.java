package com.flightApplication.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flightApplication.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	
	public List<Flight> findByEmailId(String emailId);

	public boolean existsById(String pnr);

	public Optional<Flight> findById(String pnr);
}
