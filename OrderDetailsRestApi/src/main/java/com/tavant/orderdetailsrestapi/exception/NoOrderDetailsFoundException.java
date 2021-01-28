package com.tavant.orderdetailsrestapi.exception;

public class NoOrderDetailsFoundException extends Exception {

	public NoOrderDetailsFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
