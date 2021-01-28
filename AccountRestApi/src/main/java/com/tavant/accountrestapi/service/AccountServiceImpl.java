package com.tavant.accountrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.accountrestapi.model.Account;
import com.tavant.accountrestapi.repository.AccountRepository;
@Service

public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public boolean addAccount(Account account) {

		Account acc = accountRepository.save(account);
		return acc!=null;
	}

	@Override
	public Optional<Account> updateAccount(String accNumber, Account account) {
		
		if(accountRepository.findById(accNumber).isPresent()) {
			Account acc = accountRepository.findById(accNumber).get();

			acc.setFirstName(account.getFirstName());
			acc.setLastName(account.getLastName());
			acc.setBalance(account.getBalance());
			acc.setAccountType(account.getAccountType());
			acc.setAccountNumber(account.getAccountNumber());
			
			final Account updatedAccount = accountRepository.save(acc);
			return Optional.ofNullable(updatedAccount);
		}
		return null;
	}

	@Override
	public boolean deleteAccount(String accNumber) {
		// TODO Auto-generated method stub
		if(accountRepository.existsById(accNumber)) {
			accountRepository.deleteById(accNumber);
			return true;
		}
		return false;
	}

	@Override
	public Optional<Account> getAccountById(String accNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accNumber);
	}

	@Override
	public Optional<List<Account>> getAccounts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(accountRepository.findAll());
	}

	@Override
	public boolean AccountExistById(String accNumber) {
		// TODO Auto-generated method stub
		return accountRepository.existsById(accNumber);
	}

}
