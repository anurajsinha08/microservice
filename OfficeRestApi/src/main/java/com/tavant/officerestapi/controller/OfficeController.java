package com.tavant.officerestapi.controller;

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

import com.tavant.officerestapi.exception.NoOfficeFoundException;
import com.tavant.officerestapi.exception.OfficeNotFoundException;
import com.tavant.officerestapi.model.Offices;
import com.tavant.officerestapi.service.OfficeService;

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
//@RequestMapping("/api/office")
// This means that here we have the resources for employee
public class OfficeController {

	@Autowired
	OfficeService officeService;
	
	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<Offices>> getOffices() throws NoOfficeFoundException{
		Optional<List<Offices>> off = officeService.getOffices();
		if(off.get().size()==0) {
			throw new NoOfficeFoundException("No Office Data Exist");
		}
		else {
			return off;
		}
	}
	
	
	//To get record of specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getOfficeById(@PathVariable("id") String offID) throws OfficeNotFoundException {

		Optional<Offices> off = officeService.getOfficeById(offID);

		if(off.isPresent()) {
			return ResponseEntity.ok(off.get());
		}
		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EmployeeNotFoundException("Record not found"));
			throw new OfficeNotFoundException("Office Not Found");	
		}
	}
	
	@PostMapping("/add")
	public boolean addOffice(@RequestBody @Valid Offices office) {
		return officeService.addOffice(office);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOffice(@PathVariable("id") String offID) throws OfficeNotFoundException {

		String off = officeService.deleteOffice(offID);

		if(off.equals("success")) {
			return ResponseEntity.ok(off);
		}
		else {
			throw new OfficeNotFoundException("Office Not Found");	
		}
	}
	
}
