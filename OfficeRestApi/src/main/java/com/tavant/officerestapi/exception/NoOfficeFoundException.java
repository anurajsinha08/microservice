package com.tavant.officerestapi.exception;

public class NoOfficeFoundException extends Exception {

	public NoOfficeFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
