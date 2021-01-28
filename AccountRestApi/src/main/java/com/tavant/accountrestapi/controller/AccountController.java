package com.tavant.accountrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.accountrestapi.exception.AccountNotFoundException;
import com.tavant.accountrestapi.exception.NoAccountFoundException;
import com.tavant.accountrestapi.model.Account;
import com.tavant.accountrestapi.service.AccountService;

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
//@RequestMapping("/api/account")
// This means that here we have the resources for employee
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<Account>> getAccounts() throws NoAccountFoundException{
		Optional<List<Account>> acc = accountService.getAccounts();
		if(acc.get().size()==0) {
			throw new NoAccountFoundException("No Account Data Exist");
		}
		else {
			return acc;
		}
	}


	//To get record of specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") String accID) throws AccountNotFoundException {

		Optional<Account> acc = accountService.getAccountById(accID);

		if(acc.isPresent()) {
			return ResponseEntity.ok(acc.get());
		}
		else {
			System.out.println("Hello from account");
			throw new AccountNotFoundException("Account Not Found");	
		}
	}

	@PostMapping("/add")
	public boolean addAccount(@RequestBody @Valid Account account) {
		return accountService.addAccount(account);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") String accID) throws AccountNotFoundException {

		boolean acc = accountService.deleteAccount(accID);

		if(acc) {
			return ResponseEntity.ok(acc);
		}
		else {
			throw new AccountNotFoundException("Account Not Found");	
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable("id") String Id, @Valid @RequestBody Account accountDetails) throws AccountNotFoundException {
		
		Optional<Account> acc = accountService.updateAccount(Id, accountDetails);

		if(acc.isPresent()) {
			return ResponseEntity.ok(acc.get());
		}
		else {
			throw new AccountNotFoundException("Account Not Found");	
		}
	
	}
}
