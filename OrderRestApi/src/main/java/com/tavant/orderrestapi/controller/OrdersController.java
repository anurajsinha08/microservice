package com.tavant.orderrestapi.controller;

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

import com.tavant.orderrestapi.exception.NoOrderFoundException;
import com.tavant.orderrestapi.exception.OrderNotFoundException;
import com.tavant.orderrestapi.model.Orders;
import com.tavant.orderrestapi.service.OrdersService;

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
//@RequestMapping("/api/order")
// This means that here we have the resources for employee
public class OrdersController {

	@Autowired
	OrdersService orderService;
	
	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<Orders>> getOrders() throws NoOrderFoundException{
		Optional<List<Orders>> o = orderService.getOrders();
		if(o.get().size()==0) {
			throw new NoOrderFoundException("No Order Data Exist");
		}
		else {
			return o;
		}
	}
	
	
	//To get record of specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable("id") int orderNumber) throws OrderNotFoundException {

		Optional<Orders> o = orderService.getOrdersById(orderNumber);

		if(o.isPresent()) {
			return ResponseEntity.ok(o.get());
		}
		else {
			throw new OrderNotFoundException("Order Not Found");	
		}
	}
	
	@PostMapping("/add")
	public boolean addOrder(@RequestBody @Valid Orders order) {
		return orderService.addOrders(order);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") int orderNumber) throws OrderNotFoundException {

		String o = orderService.deleteOrders(orderNumber);

		if(o.equals("success")) {
			return ResponseEntity.ok(o);
		}
		else {
			throw new OrderNotFoundException("Order Not Found");	
		}
	}
}
