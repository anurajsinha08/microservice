package com.tavant.orderrestapi.exception;

public class OrderNotFoundException extends Exception {

	public OrderNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
