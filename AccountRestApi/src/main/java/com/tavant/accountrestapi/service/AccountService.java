package com.tavant.accountrestapi.service;

import java.util.List;
import java.util.Optional;

import com.tavant.accountrestapi.model.Account;

public interface AccountService {
	public boolean addAccount(Account account);
	public Optional<Account> updateAccount(String accNumber, Account account);
	public boolean deleteAccount(String accNumber);
	public Optional<Account> getAccountById(String accNumber);
	public Optional<List<Account>> getAccounts();
	public boolean AccountExistById(String accNumber);
}
