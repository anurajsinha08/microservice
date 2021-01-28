package com.tavant.customerrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.customerrestapi.model.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{
	
	
}
