package com.tavant.paymentrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.paymentrestapi.model.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

}
