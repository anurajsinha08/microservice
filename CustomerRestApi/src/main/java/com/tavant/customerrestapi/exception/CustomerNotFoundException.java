package com.tavant.customerrestapi.exception;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
