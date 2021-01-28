package com.tavant.orderdetailsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.orderdetailsrestapi.model.OrderDetails;
import com.tavant.orderdetailsrestapi.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Override
	public boolean addOrderDetails(OrderDetails orderDetails) {
		
		OrderDetails details = orderDetailsRepository.save(orderDetails);
		return details!=null;
	}

	@Override
	public String deleteOrderDetails(int orderNumber) {
		if(orderDetailsRepository.existsById(orderNumber)) {
			orderDetailsRepository.deleteById(orderNumber);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<OrderDetails> updateOrderDetails(int orderNumber, OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<OrderDetails> getOrderDetailsById(int orderNumber) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findById(orderNumber);
	}

	@Override
	public Optional<List<OrderDetails>> getOrderDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(orderDetailsRepository.findAll());
	}

	@Override
	public boolean OrderDetailsExistById(int orderNumber) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.existsById(orderNumber);
	}
}
