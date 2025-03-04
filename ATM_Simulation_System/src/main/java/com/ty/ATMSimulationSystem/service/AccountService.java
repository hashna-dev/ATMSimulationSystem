package com.ty.mySpringBank.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.mySpringBank.model.Account;
import com.ty.mySpringBank.model.Transaction;
import com.ty.mySpringBank.repository.AccountRepository;
import com.ty.mySpringBank.repository.TransactionRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
    public Account getAccountByNumber(String accountNumber) {
    	return accountRepository.findByaccountNumber(accountNumber);
    }
    public void deposit(String accountNumber, double amount) {
    	Account account= accountRepository.findByaccountNumber(accountNumber);
    	account.setBalance(account.getBalance()+amount);
    	accountRepository.save(account);
    	Transaction transaction=new Transaction();
    	transaction.setAccount(account);
    	transaction.setAmount(amount);
    	transaction.setType("Deposit");
    	transaction.setTimeStamp(new Date());
    	transactionRepository.save(transaction);
   	
    }
    public void withdraw(String accountNumber, double amount) {
    	Account account= accountRepository.findByaccountNumber(accountNumber);
    	if(account.getBalance()>=amount) {
    	account.setBalance(account.getBalance()-amount);
    	accountRepository.save(account);
    	Transaction transaction=new Transaction();
    	transaction.setAccount(account);
    	transaction.setAmount(amount);
    	transaction.setType("Withdraw");
    	transaction.setTimeStamp(new Date());
    	transactionRepository.save(transaction);
    	}
    	else {
    		 throw new RuntimeException("Insufficient balance");
    	}
    }
    
    public List<Transaction> getTransactions(String accountNumber){
    	Account account=accountRepository.findByaccountNumber(accountNumber);
    	if(account!=null) {
    		return transactionRepository.findByAccountId(account.getId());	
    	}
    	else {
    		 throw new RuntimeException("INVALID TRANSACTION");
    	}
    	
    }
    
}
