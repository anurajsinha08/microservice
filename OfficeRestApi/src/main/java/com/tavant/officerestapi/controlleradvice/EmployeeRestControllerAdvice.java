package com.tavant.officerestapi.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.officerestapi.errorresponse.ErrorResponse;
import com.tavant.officerestapi.exception.NoOfficeFoundException;
import com.tavant.officerestapi.exception.OfficeNotFoundException;

//It will be applied to all the controller so we will mark @ControllerAdvice annotation
// It will hold all the exception class

@ControllerAdvice
public class EmployeeRestControllerAdvice {

	@ExceptionHandler(OfficeNotFoundException.class)

	public final ResponseEntity<ErrorResponse> handleOfficeNotFoundException(OfficeNotFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoOfficeFoundException.class)

	public final ResponseEntity<ErrorResponse> handleNoOfficeException(NoOfficeFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
}
