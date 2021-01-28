package com.tavant.paymentrestapi.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.thoughtworks.xstream.converters.time.LocalDateConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Payments {

	@Id
	@NotNull(message = "Payment Id cannot be null")
	private int paymentId;
//	@ManyToOne
//	@JoinColumn(name = "customerNumber")
	@NotBlank(message = "Customer Number cannot be null")
	private String customerNumber;
	@NotNull(message = "Amount cannot be null")
	@Min(0)
	private double amount;
	@NotBlank(message = "Check Number cannot be null")
//	@Max(5)
	@Min(0)
	private String checkNumber;
//	@NotNull(message = "Payment Date cannot be null")
	private LocalDate paymentDate;

//	public void setPaymentDate(LocalDate paymentDate) {
//		this.paymentDate = LocalDate.now();
//	}
}
