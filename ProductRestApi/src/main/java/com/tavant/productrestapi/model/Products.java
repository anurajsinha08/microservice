package com.tavant.productrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Products {

	@Id
//	private int productId;
//	@ManyToOne
//	@JoinColumn(name = "productCode")
	@NotBlank(message = "Product Code cannot be empty")
	private String productCode;
	@NotNull(message = "Buying price cannot be null")
	private double buyPrice;
	@NotNull(message = "MSRP cannot be null")
	private double MSRP;
	@NotBlank(message = "Product description cannot be empty")
	private String productDescription;
	private String productLine;
	@NotBlank(message = "Product Name cannot be empty")
	private String productName;
	private String productScale;
	private String productVendor;
	@NotNull(message = "Quality in stock cannot be empty")
	private int qualityInStock;
	
//	@OneToMany (mappedBy = "productLine", fetch = FetchType.LAZY)
//	private List<ProductLines> productLineList;

}
