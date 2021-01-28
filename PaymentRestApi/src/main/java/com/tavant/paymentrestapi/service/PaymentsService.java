package com.tavant.paymentrestapi.service;

import java.util.List;
import java.util.Optional;

import com.tavant.paymentrestapi.model.Payments;

public interface PaymentsService {

	public boolean addPayments(Payments payments);
	public Optional<Payments> updateOffice(int custNumber, Payments payments);
	public String deletePayments(int custNumber);
	public Optional<Payments> getPaymentsById(int custNumber);
	public Optional<List<Payments>> getPayments();
	public boolean paymnetsExistById(int custNumber);
	
}
