package com.tavant.paymentrestapi.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.paymentrestapi.errorresponse.ErrorResponse;
import com.tavant.paymentrestapi.exception.NoPaymentFoundException;
import com.tavant.paymentrestapi.exception.PaymentNotFoundException;

//It will be applied to all the controller so we will mark @ControllerAdvice annotation
// It will hold all the exception class

@ControllerAdvice
public class EmployeeRestControllerAdvice {

	@ExceptionHandler(PaymentNotFoundException.class)

	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(PaymentNotFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();

		details.add(e.getLocalizedMessage());

		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoPaymentFoundException.class)

	public final ResponseEntity<ErrorResponse> handleNoEmployeeException(NoPaymentFoundException e, WebRequest request) {

		List<String> details = new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT_REQUEST",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
