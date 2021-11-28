package com.flightApplication.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirlineBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airlineId;
	private String airlineName;
	private String uploadLogo;
	private String contactName;
	private String contactAddr;
	
	

	public AirlineBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AirlineBooking(String airlineName, String uploadLogo, String contactName, String contactAddr) {
		super();
		this.airlineName = airlineName;
		this.uploadLogo = uploadLogo;
		this.contactName = contactName;
		this.contactAddr = contactAddr;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getUploadLogo() {
		return uploadLogo;
	}
	public void setUploadLogo(String uploadLogo) {
		this.uploadLogo = uploadLogo;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactAddr() {
		return contactAddr;
	}
	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}
	@Override
	public String toString() {
		return "Airline [airlineName=" + airlineName + ", uploadLogo=" + uploadLogo + ", contactName=" + contactName
				+ ", contactAddr=" + contactAddr + "]";
	}	
	
}
