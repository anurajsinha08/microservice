package com.tavant.customerrestapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customers {

	@Id
	@NotNull(message = "Customer Number cannot be null")
	private int customerNumber;
	@NotBlank(message = "Customer Name cannot be empty")
	private String customerName;
	@NotBlank(message = "Customer Last Name cannot be empty")
	private String contactLastName;
	@NotBlank(message = "Customer First Name cannot be empty")
	private String contactFirstName;
	@NotBlank(message = "Customer phone number cannot be empty")
//	@Max(10)
	@Min(0)
	private String phone;
	@NotBlank(message = "Customer address cannot be empty")
	private String addressLine1;
	private String addressLine2;
	@NotBlank(message = "Customer city cannot be empty")
	private String city;
	@NotBlank(message = "Customer country cannot be empty")
	private String country;
	@NotNull(message = "Please define a credit limit")
	private double creditLimit;
	@NotBlank(message = "Postal Code cannot be empty")
	private String postalCode;
	@NotNull(message = "Sales Representative number cannot be empty")
	private int salesRepEmployeeNumber;
	@NotBlank(message = "Customer state cannot be empty")
	private String state;
	
//	@OneToMany (mappedBy = "customerNumber", fetch = FetchType.LAZY)
//	private List<Payments> paymentsList;
//	
//	@OneToMany (mappedBy = "customerNumber", fetch = FetchType.EAGER)
//	private List<Orders> ordersList;

}
