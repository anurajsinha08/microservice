package com.tavant.employeerestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "employees")
public class Employee {

	@Id 
	@Column(length=10)
	private int employeeNumber;
	
	@NotBlank(message="last name cannot be empty")
	private String lastName;
	
	@NotBlank(message="first name cannot be empty")
	private String firstName;
	
	@NotBlank(message="Extension cannot be empty")
	private String extension;
	
	@NotBlank(message="Email cannot be empty")
	@Email(message = "Email should be valid")
	private String email;
	
	// For integer do not use @NotBlank, else use @Size, @NotNull, etc
	@NotNull(message = "Office code cannot be null")
	@Max(123)
	@Min(1)
	private Integer officeCode;
	
	private int reportsTo;
	
	@NotBlank(message="Job Title cannot be empty")
	private String jobTitle;

	

}
