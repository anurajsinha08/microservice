package com.tavant.orderdetailsrestapi.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.orderdetailsrestapi.errorresponse.ErrorResponse;
import com.tavant.orderdetailsrestapi.exception.NoOrderDetailsFoundException;
import com.tavant.orderdetailsrestapi.exception.OrderDetailsNotFoundException;

//It will be applied to all the controller so we will mark @ControllerAdvice annotation
// It will hold all the exception class

@ControllerAdvice
public class EmployeeRestControllerAdvice {

	@ExceptionHandler(OrderDetailsNotFoundException.class)

	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(OrderDetailsNotFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();

		details.add(e.getLocalizedMessage());

		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoOrderDetailsFoundException.class)

	public final ResponseEntity<ErrorResponse> handleNoEmployeeException(NoOrderDetailsFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
}
