package com.tavant.officerestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "office")
public class Offices {
	// We have created offices also because employee table has reference with offices where office code is the foreign key in employee table
	@Id
	@NotBlank(message = "office code cannot be empty")
	private String officeCode;
	@NotBlank(message = "city cannot be empty")
	private String city;
	@NotBlank(message = "phone number cannot be empty")
	private String phone;
	@NotBlank(message = "address1 cannot be empty")
	private String addressLine1;
	private String addressLine2;
	@NotBlank(message = "state cannot be empty")
	private String state;
	@NotBlank(message = "country cannot be empty")
	private String country;
	@NotBlank(message = "postal cannot be empty")
	private String postalCode;
	private String territory;
	
}
