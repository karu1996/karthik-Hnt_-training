package com.flightApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApplication.entities.Schedule;

public interface AirlineScheduleRepository extends JpaRepository<Schedule, Integer> {

	public Schedule findByFlightNo(String flightNo);

	public boolean existsByairline(String airline);

	public boolean existsByflightNo(int flightNo);
}
