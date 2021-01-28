package com.tavant.orderdetailsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.tavant.orderdetailsrestapi.model.OrderDetails;

public interface OrderDetailsService {

	public boolean addOrderDetails(OrderDetails orderDetails);
	public String deleteOrderDetails(int orderNumber);
	public Optional<OrderDetails> updateOrderDetails(int orderNumber, OrderDetails orderDetails);
	public Optional<OrderDetails> getOrderDetailsById(int orderNumber);
	public Optional<List<OrderDetails>> getOrderDetails();
	public boolean OrderDetailsExistById(int orderNumber);
	
}
