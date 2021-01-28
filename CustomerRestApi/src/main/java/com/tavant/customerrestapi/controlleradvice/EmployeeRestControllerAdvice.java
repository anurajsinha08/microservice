package com.tavant.customerrestapi.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.customerrestapi.errorresponse.ErrorResponse;
import com.tavant.customerrestapi.exception.CustomerNotFoundException;
import com.tavant.customerrestapi.exception.NoCustomerFoundException;

//It will be applied to all the controller so we will mark @ControllerAdvice annotation
// It will hold all the exception class

@ControllerAdvice
public class EmployeeRestControllerAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)

	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(CustomerNotFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();

		details.add(e.getLocalizedMessage());

		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoCustomerFoundException.class)

	public final ResponseEntity<ErrorResponse> handleNoEmployeeException(NoCustomerFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
}
