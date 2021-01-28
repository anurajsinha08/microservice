package com.tavant.paymentrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.paymentrestapi.exception.NoPaymentFoundException;
import com.tavant.paymentrestapi.exception.PaymentNotFoundException;
import com.tavant.paymentrestapi.model.Payments;
import com.tavant.paymentrestapi.service.PaymentsService;

//To perform the work of controller if we are using spring MVC
// then we will use @Controller
// but here we are using rest then
// we should use @RestController

//This annotation is introduced from spring mvc version 4.x
// before spring 3.0 was a combination of
//@ResponseEntity and @Controller
// in 4.0 they form @RestController
// When we will deal with any rest application there we have to
// send the response will be a json,html,xml, or any file
// wherever we have to share the data there we have to mark @repository
// then what they have done instead of marking it on each and every method
// they come up with a solution @RestController

@RestController
//@RequestMapping("/api/payment")
// This means that here we have the resources for employee
public class PaymentsController {

	@Autowired
	PaymentsService paymentService;
	
	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<Payments>> getPayments() throws NoPaymentFoundException{
		Optional<List<Payments>> pay = paymentService.getPayments();
		if(pay.get().size()==0) {
			throw new NoPaymentFoundException("No Payment Data Exist");
		}
		else {
			return pay;
		}
	}
	
	
	//To get record of specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getPaymentById(@PathVariable("id") int paymentId) throws PaymentNotFoundException {

		Optional<Payments> pay = paymentService.getPaymentsById(paymentId);

		if(pay.isPresent()) {
			return ResponseEntity.ok(pay.get());
		}
		else {
			throw new PaymentNotFoundException("Payment Not Found");	
		}
	}
	
	@PostMapping("/add")
	public boolean addPayment(@RequestBody @Valid Payments payment) {
		return paymentService.addPayments(payment);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePayment(@PathVariable("id") int paymentId) throws PaymentNotFoundException {

		String pay = paymentService.deletePayments(paymentId);

		if(pay.equals("success")) {
			return ResponseEntity.ok(pay);
		}
		else {
			throw new PaymentNotFoundException("Payment Not Found");	
		}
	}
}
