package com.tavant.paymentrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.paymentrestapi.model.Payments;
import com.tavant.paymentrestapi.repository.PaymentsRepository;
@Service

public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	PaymentsRepository paymentsRepository;

	@Override
	public boolean addPayments(Payments payments) {
		
		Payments pay = paymentsRepository.save(payments);
		return pay!=null;
	}

	@Override
	public Optional<Payments> updateOffice(int custNumber, Payments payments) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePayments(int custNumber) {

		if(paymentsRepository.existsById(custNumber)) {
			paymentsRepository.deleteById(custNumber);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Payments> getPaymentsById(int custNumber) {
		// TODO Auto-generated method stub
		return paymentsRepository.findById(custNumber);
	}

	@Override
	public Optional<List<Payments>> getPayments() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(paymentsRepository.findAll());
	}

	@Override
	public boolean paymnetsExistById(int custNumber) {
		// TODO Auto-generated method stub
		return paymentsRepository.existsById(custNumber);
	}

}