package com.tavant.accountrestapi.exception;

public class AccountNotFoundException extends Exception {

	public AccountNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
