package com.tavant.employeerestapi.exception;

public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
