package com.tavant.orderrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.orderrestapi.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	
}
