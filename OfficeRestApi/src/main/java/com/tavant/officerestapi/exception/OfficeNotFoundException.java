package com.tavant.officerestapi.exception;

public class OfficeNotFoundException extends Exception {

	public OfficeNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
