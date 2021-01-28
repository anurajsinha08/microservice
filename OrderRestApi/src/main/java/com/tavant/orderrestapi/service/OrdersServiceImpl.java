package com.tavant.orderrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.orderrestapi.model.Orders;
import com.tavant.orderrestapi.repository.OrdersRepository;
@Service

public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public boolean addOrders(Orders order) {
		Orders orders = ordersRepository.save(order);
		return orders!=null;
	}

	@Override
	public String deleteOrders(int orderNumber) {
		
		if(ordersRepository.existsById(orderNumber)) {
			ordersRepository.deleteById(orderNumber);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Orders> updateOrders(int orderNumber, Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Orders> getOrdersById(int orderNumber) {
		// TODO Auto-generated method stub
		return ordersRepository.findById(orderNumber);
	}

	@Override
	public Optional<List<Orders>> getOrders() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(ordersRepository.findAll());
	}

	@Override
	public boolean OrdersExistById(int orderNumber) {
		// TODO Auto-generated method stub
		return ordersRepository.existsById(orderNumber);
	}

}
