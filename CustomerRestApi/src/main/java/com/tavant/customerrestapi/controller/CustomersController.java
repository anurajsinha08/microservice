package com.tavant.customerrestapi.controller;

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

import com.tavant.customerrestapi.exception.CustomerNotFoundException;
import com.tavant.customerrestapi.exception.NoCustomerFoundException;
import com.tavant.customerrestapi.model.Customers;
import com.tavant.customerrestapi.service.CustomersService;

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
//@RequestMapping("/api/customer")
// This means that here we have the resources for employee
public class CustomersController {

	@Autowired
	CustomersService customerService;
	
	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<Customers>> getCustomers() throws NoCustomerFoundException{
		Optional<List<Customers>> cust = customerService.getCustomers();
		if(cust.get().size()==0) {
			throw new NoCustomerFoundException("No Customer Data Exist");
		}
		else {
			return cust;
		}
	}
	
	
	//To get record of specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") int custID) throws CustomerNotFoundException {

		Optional<Customers> cust = customerService.getCustomerById(custID);

		if(cust.isPresent()) {
			return ResponseEntity.ok(cust.get());
		}
		else {
			throw new CustomerNotFoundException("Customer Not Found");	
		}
	}
	
	@PostMapping("/add")
	public boolean addCustomer(@RequestBody @Valid Customers customer) {
		return customerService.addCustomer(customer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") int custID) throws CustomerNotFoundException {

		String cust = customerService.deleteCustomer(custID);

		if(cust.equals("success")) {
			return ResponseEntity.ok(cust);
		}
		else {
			throw new CustomerNotFoundException("Customer Not Found");	
		}
	}
	
	
}
