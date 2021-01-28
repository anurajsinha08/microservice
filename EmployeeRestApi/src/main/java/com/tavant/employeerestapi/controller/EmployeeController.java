package com.tavant.employeerestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.employeerestapi.exception.EmployeeNotFoundException;
import com.tavant.employeerestapi.exception.NoEmployeeFoundException;
import com.tavant.employeerestapi.model.Employee;
import com.tavant.employeerestapi.service.EmployeeService;

//To perform the work of controller if we are using spring MVC
// then we will use @Controller
// but here we are using rest then
// we should use @RestController

//This annotation is introduced from spring mvc version 4.x
// before spring 3.0 was a combination of
//@ResponseEntity and @Controller
// in 4.0 they form @RestController
// When we will deal with any rest application there we have to
// send the response will be a json,html,xml, or any file
// wherever we have to share the data there we have to mark @repository
// then what they have done instead of marking it on each and every method
// they come up with a solution @RestController

@RestController
//@RequestMapping("/api/employee")
// This means that here we have the resources for employee
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<Employee>> getEmployees() throws NoEmployeeFoundException{
		Optional<List<Employee>> emp = employeeService.getEmployees();
		if(emp.get().size()==0) {
			throw new NoEmployeeFoundException("No Employee Data Exist");
		}
		else {
			return emp;
		}
	}
	
//	public ResponseEntity<Employee> getEmployees() throws NoEmployeeFoundException{
//		
//		Optional<List<Employee>> emp = employeeService.getEmployees();
//		
//		if(emp.isPresent()) {
//			return ResponseEntity.ok(emp.get());
//			
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employees details found");
//		}
//	}
	
	//To get record of specific id
	@GetMapping("/{id}")
//	public Employee getEmployeeById(@PathVariable("id") int empID) throws EmployeeNotFoundException {
//		return employeeService.getEmployeeById(empID)
//				.orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
//	}
	
	//For setting appropriate error mesage according to statndrs
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int empID) throws EmployeeNotFoundException {

		Optional<Employee> emp = employeeService.getEmployeeById(empID);

		if(emp.isPresent()) {
			return ResponseEntity.ok(emp.get());
		}
		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EmployeeNotFoundException("Record not found"));
			throw new EmployeeNotFoundException("Employee Not Found");	
		}
	}
	
	@PostMapping("/add") // It will transform the json object to java object
	// Jackson api will take care implicitly
	// We can use @Validated also or @Valid
	public boolean addEmployee(@RequestBody @Valid Employee employee) {
//		if(employee.getEmployeeNumber()==0)
//		{
//			throw new NoEmployeeToBeInsertedException("Data Cannot be empty");
//		}
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") int empID) throws EmployeeNotFoundException {

		String acc = employeeService.deleteEmployee(empID);

		if(acc.equals("success")) {
			return ResponseEntity.ok(acc);
		}
		else {
			throw new EmployeeNotFoundException("Employee Not Found");	
		}
	}
	
}
