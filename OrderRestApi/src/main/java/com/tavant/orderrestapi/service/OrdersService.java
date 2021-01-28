package com.tavant.orderrestapi.service;

import java.util.List;
import java.util.Optional;

import com.tavant.orderrestapi.model.Orders;

public interface OrdersService {

	public boolean addOrders(Orders order);
	public String deleteOrders(int orderNumber);
	public Optional<Orders> updateOrders(int orderNumber, Orders order);
	public Optional<Orders> getOrdersById(int orderNumber);
	public Optional<List<Orders>> getOrders();
	public boolean OrdersExistById(int orderNumber);
	
}
