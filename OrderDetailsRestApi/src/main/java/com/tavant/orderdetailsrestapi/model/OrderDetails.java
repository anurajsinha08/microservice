package com.tavant.orderdetailsrestapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

public class OrderDetails {

	@Id
	@NotNull(message = "Order Details Id cannot be null")
	private int orderDetailsId;
//	@ManyToOne
//	@JoinColumn (name = "orderNumber")
	@NotBlank(message = "Order Number cannot be null")
	private String orderNumber;
	@NotBlank(message = "Product Code cannot be null")
	private String productCode;
	@NotNull(message = "Order Line Number cannot be null")
	private int orderLineNumber;
	@NotNull(message = "Price cannot be empty")
	private double priceEach;
	@NotNull(message = "Quantity must be entered")
	@Min(0)
	private int quantityOrdered;
	
//	@OneToMany (mappedBy = "productCode", fetch = FetchType.LAZY)
//	private List<Products> productCodeList;

}
