package com.tavant.orderrestapi.exception;

public class NoOrderFoundException extends Exception {

	public NoOrderFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
