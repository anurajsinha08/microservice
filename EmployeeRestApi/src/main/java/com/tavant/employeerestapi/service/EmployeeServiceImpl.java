package com.tavant.employeerestapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.employeerestapi.model.Employee;
import com.tavant.employeerestapi.repository.EmployeeRepository;
@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeesRepository;
	
	@Override
	public boolean addEmployee(Employee employee) {
		
		Employee employee1 = employeesRepository.save(employee);
		//This save method will help to insert record to a table
		return employee1!=null;
	}

	@Override
	public Optional<Employee> updateEmployee(int empID, Employee employee) {
		
		
		return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		if(employeesRepository.existsById(empId)) {
			employeesRepository.deleteById(empId);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Employee> getEmployeeById(int empID) {
		
		return employeesRepository.findById(empID);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {

		return Optional.ofNullable(employeesRepository.findAll());
	}

	@Override
	public boolean employeeExistById(int empId) {
		
		return employeesRepository.existsById(empId);
	}

	@Override
	public Optional<Set<String>> checkOfficeCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
