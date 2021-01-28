package com.tavant.orderdetailsrestapi.controller;

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

import com.tavant.orderdetailsrestapi.exception.NoOrderDetailsFoundException;
import com.tavant.orderdetailsrestapi.exception.OrderDetailsNotFoundException;
import com.tavant.orderdetailsrestapi.model.OrderDetails;
import com.tavant.orderdetailsrestapi.service.OrderDetailsService;

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
//@RequestMapping("/api/orderDetails")
// This means that here we have the resources for employee
public class OrderDetailsController {

	@Autowired
	OrderDetailsService orderDetailsService;
	
	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<OrderDetails>> getOrderDetails() throws NoOrderDetailsFoundException{
		Optional<List<OrderDetails>> od = orderDetailsService.getOrderDetails();
		if(od.get().size()==0) {
			throw new NoOrderDetailsFoundException("No Order Details Data Exist");
		}
		else {
			return od;
		}
	}
	
	
	//To get record of specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderDetailsById(@PathVariable("id") int accID) throws OrderDetailsNotFoundException {

		Optional<OrderDetails> od = orderDetailsService.getOrderDetailsById(accID);

		if(od.isPresent()) {
			return ResponseEntity.ok(od.get());
		}
		else {
			throw new OrderDetailsNotFoundException("Order Details Not Found");	
		}
	}
	
	@PostMapping("/add")
	public boolean addOrderDetails(@RequestBody @Valid OrderDetails orderDetails) {
		return orderDetailsService.addOrderDetails(orderDetails);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrderDetails(@PathVariable("id") int orderDetailsID) throws OrderDetailsNotFoundException {

		String od = orderDetailsService.deleteOrderDetails(orderDetailsID);

		if(od.equals("success")) {
			return ResponseEntity.ok(od);
		}
		else {
			throw new OrderDetailsNotFoundException("Order Details Not Found");	
		}
	}
	
}
