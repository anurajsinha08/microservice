package com.tavant.accountrestapi.exception;

public class NoAccountFoundException extends Exception {

	public NoAccountFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
