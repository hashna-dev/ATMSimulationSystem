package com.ty.atm.service;

import com.ty.atm.model.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ATMService {

    private Map<Long, Account> accounts = new HashMap<>();

    public ATMService() {
        accounts.put(13970100160661L, new Account(13970100160661L, "2025", 100000));
        accounts.put(12345678901234L, new Account(12345678901234L, "1234", 50000));
    }

    public boolean validateAccount(Long accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        return account != null && account.getPin().equals(pin);
    }

    public double checkBalance(Long accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        if (account == null || !account.getPin().equals(pin)) {
            throw new RuntimeException("Invalid account number or PIN");
        }
        return account.getBalance();
    }

    public String deposit(Long accountNumber, String pin, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null || !account.getPin().equals(pin)) {
            throw new RuntimeException("Invalid account number or PIN");
        }
        account.setBalance(account.getBalance() + amount);
        return "Deposit successful. New balance: ₹" + account.getBalance();
    }

    public String withdraw(Long accountNumber, String pin, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null || !account.getPin().equals(pin)) {
            throw new RuntimeException("Invalid account number or PIN");
        }
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return "Withdrawal successful. Remaining balance: ₹" + account.getBalance();
    }
}
