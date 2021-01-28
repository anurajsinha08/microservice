package com.tavant.paymentrestapi.exception;

public class NoPaymentFoundException extends Exception {

	public NoPaymentFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
