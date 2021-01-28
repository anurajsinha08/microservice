package com.tavant.paymentrestapi.exception;

public class PaymentNotFoundException extends Exception {

	public PaymentNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
