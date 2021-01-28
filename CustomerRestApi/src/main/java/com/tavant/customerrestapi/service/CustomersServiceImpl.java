package com.tavant.customerrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.customerrestapi.model.Customers;
import com.tavant.customerrestapi.repository.CustomersRepository;
@Service

public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersRepository customersRepository;

	@Override
	public boolean addCustomer(Customers customer) {
		// TODO Auto-generated method stub
		Customers cust = customersRepository.save(customer);
		return cust!=null;
	}

	@Override
	public Optional<Customers> updateCustomer(int custNumber, Customers customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(int custNumber) {
		if(customersRepository.existsById(custNumber)) {
			customersRepository.deleteById(custNumber);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Customers> getCustomerById(int custNumber) {
		// TODO Auto-generated method stub
		return customersRepository.findById(custNumber);
	}

	@Override
	public Optional<List<Customers>> getCustomers() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(customersRepository.findAll());
	}

	@Override
	public boolean CustomerExistById(int custNumber) {
		// TODO Auto-generated method stub
		return customersRepository.existsById(custNumber);
	}
	

}
