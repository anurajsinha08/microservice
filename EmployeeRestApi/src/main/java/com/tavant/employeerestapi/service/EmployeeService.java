package com.tavant.employeerestapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.tavant.employeerestapi.model.Employee;

public interface EmployeeService {
	
	public boolean addEmployee(Employee employee);
	public Optional<Employee> updateEmployee(int empID, Employee employee);
	public String deleteEmployee(int empId);
	public Optional<Employee> getEmployeeById(int empID);
	public Optional<List<Employee>> getEmployees();
	
	public boolean employeeExistById(int empId);
	public Optional<Set<String>> checkOfficeCode();

	// We are doing chages in Service class also becoz our DAO class is returning optional data
	
}
