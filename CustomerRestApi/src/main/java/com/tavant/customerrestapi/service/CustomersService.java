package com.tavant.customerrestapi.service;

import java.util.List;
import java.util.Optional;

import com.tavant.customerrestapi.model.Customers;

public interface CustomersService {
	public boolean addCustomer(Customers customer);
	public Optional<Customers> updateCustomer(int custNumber, Customers customer);
	public String deleteCustomer(int custNumber);
	public Optional<Customers> getCustomerById(int custNumber);
	public Optional<List<Customers>> getCustomers();
	public boolean CustomerExistById(int custNumber);
	
}
