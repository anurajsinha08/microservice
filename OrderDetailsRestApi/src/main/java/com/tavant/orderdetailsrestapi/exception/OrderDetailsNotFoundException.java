package com.tavant.orderdetailsrestapi.exception;

public class OrderDetailsNotFoundException extends Exception {

	public OrderDetailsNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
