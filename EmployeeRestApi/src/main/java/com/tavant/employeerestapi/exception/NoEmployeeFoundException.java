package com.tavant.employeerestapi.exception;

public class NoEmployeeFoundException extends Exception {

	public NoEmployeeFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
