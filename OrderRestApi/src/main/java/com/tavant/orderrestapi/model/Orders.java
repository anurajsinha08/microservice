package com.tavant.orderrestapi.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Orders {

	@Id
	@NotNull(message = "Order Number cannot be null")
	private int orderNumber;
//	@ManyToOne
//	@JoinColumn(name = "customerNumber")
	@NotBlank(message = "Customer Number cannot be null")
	private String customerNumber;
	@NotNull(message = "Date cannot be null")
	private LocalDate orderDate;
	private String comments;
	@NotNull(message = "Required Date cannot be null")
	private LocalDate requiredDate;
	@NotNull(message = "Shipped Date cannot be null")
	private LocalDate shippedDate;
	@NotBlank(message = "Status cannot be null")
	private String status;
	
//	@OneToMany (mappedBy = "orderNumber", fetch = FetchType.EAGER)
//	private List<OrderDetails> orderDetailsList;
	
}
