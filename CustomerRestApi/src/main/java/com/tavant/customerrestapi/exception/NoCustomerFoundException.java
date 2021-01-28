package com.tavant.customerrestapi.exception;

public class NoCustomerFoundException extends Exception {

	public NoCustomerFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
