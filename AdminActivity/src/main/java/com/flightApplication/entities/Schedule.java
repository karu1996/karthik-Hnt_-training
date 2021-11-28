package com.flightApplication.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Schedule{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightNo;
	private String airline;
	private String fromPlace;
	private String toPlace;
	private Date startDateTime;
	private Date endDateTime;
	private String scheduleDay;
	private String instrumentUsed;
	private int noOfBusiClassSeat;
	private int noOfNonBusiClassSeat;
	private String ticketCost;
	private String noOfRows;
	private String meal;
	
	
	
	public Schedule(String airline, String fromPlace, String toPlace, Date startDateTime, Date endDateTime,
			String scheduleDay, String instrumentUsed, int noOfBusiClassSeat, int noOfNonBusiClassSeat,
			String ticketCost, String noOfRows, String meal) {
		super();
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.scheduleDay = scheduleDay;
		this.instrumentUsed = instrumentUsed;
		this.noOfBusiClassSeat = noOfBusiClassSeat;
		this.noOfNonBusiClassSeat = noOfNonBusiClassSeat;
		this.ticketCost = ticketCost;
		this.noOfRows = noOfRows;
		this.meal = meal;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getScheduleDay() {
		return scheduleDay;
	}
	public void setScheduleDay(String scheduleDay) {
		this.scheduleDay = scheduleDay;
	}
	public String getInstrumentUsed() {
		return instrumentUsed;
	}
	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}
	public int getNoOfBusiClassSeat() {
		return noOfBusiClassSeat;
	}
	public void setNoOfBusiClassSeat(int noOfBusiClassSeat) {
		this.noOfBusiClassSeat = noOfBusiClassSeat;
	}
	public int getNoOfNonBusiClassSeat() {
		return noOfNonBusiClassSeat;
	}
	public void setNoOfNonBusiClassSeat(int noOfNonBusiClassSeat) {
		this.noOfNonBusiClassSeat = noOfNonBusiClassSeat;
	}
	public String getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(String ticketCost) {
		this.ticketCost = ticketCost;
	}
	public String getNoOfRows() {
		return noOfRows;
	}
	public void setNoOfRows(String noOfRows) {
		this.noOfRows = noOfRows;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	
	/*@Override
	public String toString() {
		return "Airline [flightNo=" + flightNo + ", alrline=" + alrline + ", fromPlace=" + fromPlace + ", toPlace="
				+ toPlace + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", scheduleDay="
				+ scheduleDay + ", instrumentUsed=" + instrumentUsed + ", noOfBusiClassSeat=" + noOfBusiClassSeat
				+ ", noOfNonBusiClassSeat=" + noOfNonBusiClassSeat + ", ticketCost=" + ticketCost + ", noOfRows="
				+ noOfRows + ", meal=" + meal + "]";
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Airline [flightNo=" + flightNo + ", alrline=" + alrline + ", fromPlace=" + fromPlace + ", toPlace="
				+ toPlace + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", scheduleDay="
				+ scheduleDay + ", instrumentUsed=" + instrumentUsed + ", noOfBusiClassSeat=" + noOfBusiClassSeat
				+ ", noOfNonBusiClassSeat=" + noOfNonBusiClassSeat + ", ticketCost=" + ticketCost + ", noOfRows="
				+ noOfRows + ", meal=" + meal + "]");
		
	}*/
	
	
	
}
