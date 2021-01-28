package com.tavant.accountrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@IdClass(AccountId.class)
public class Account {

	@Id
	@NotBlank(message = "Account Number cannot be null")
//	@Max(12)
	@Min(0)
	private String accountNumber;
	@NotBlank(message = "Account Type cannot be null")
	private String accountType;
	@NotBlank(message = "First Name cannot be null")
	private String firstName;
	@NotBlank(message = "Last Name cannot be null")
	private String lastName;
	@NotNull(message = "Please update the balance")
	private float balance;
	
	
}
