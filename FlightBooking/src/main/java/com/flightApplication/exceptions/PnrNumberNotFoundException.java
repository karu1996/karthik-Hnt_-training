package com.flightApplication.exceptions;

public class PnrNumberNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public PnrNumberNotFoundException() {
		super();
	}

	public PnrNumberNotFoundException(String msg) {
		super(msg);
	}

	public PnrNumberNotFoundException(Exception exp) {
		super(exp);
	}

	public PnrNumberNotFoundException(Exception exp, String msg) {
		super(msg, exp);
	}
}
