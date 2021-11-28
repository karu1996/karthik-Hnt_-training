package com.flightApplication.exceptions;

public class EmailIDNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmailIDNotFoundException() {
		super();
	}

	public EmailIDNotFoundException(String msg) {
		super(msg);
	}

	public EmailIDNotFoundException(Exception exp) {
		super(exp);
	}

	public EmailIDNotFoundException(Exception exp, String msg) {
		super(msg, exp);
	}
}
