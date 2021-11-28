package com.flightApplication.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String flightNo;
	private int pnrNo;
	private String name;
	private String emailId;
	private int numOfSeatsToBook;
	private String passengerName;
	private String passengerGender;
	private int passengerAge;
	private String mealType;
	private String seatNum;
	
	
	
	

	public Flight(String flightNo, int pnrNo, String name, String emailId, int numOfSeatsToBook,
			String passengerName, String passengerGender, int passengerAge, String mealType, String seatNum) {
		super();
		this.flightNo = flightNo;
		this.pnrNo = pnrNo;
		this.name = name;
		this.emailId = emailId;
		this.numOfSeatsToBook = numOfSeatsToBook;
		this.passengerName = passengerName;
		this.passengerGender = passengerGender;
		this.passengerAge = passengerAge;
		this.mealType = mealType;
		this.seatNum = seatNum;
	}

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public int getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getNumOfSeatsToBook() {
		return numOfSeatsToBook;
	}
	public void setNumOfSeatsToBook(int numOfSeatsToBook) {
		this.numOfSeatsToBook = numOfSeatsToBook;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getSeaNum() {
		return seatNum;
	}
	public void setSeaNum(String seaNum) {
		this.seatNum = seaNum;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	@Override
	public String toString() {
		return "Flight [pnrNo=" + pnrNo + ", name=" + name + ", emailId=" + emailId + ", numOfSeatsToBook="
				+ numOfSeatsToBook + ", passengerName=" + passengerName + ", passengerGender=" + passengerGender
				+ ", passengerAge=" + passengerAge + ", mealType=" + mealType + ", seaNum=" + seatNum + "]";
	}
	
	


}
