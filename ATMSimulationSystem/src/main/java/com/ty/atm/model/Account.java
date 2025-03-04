package com.ty.atm.model;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private Long accountNumber;
    private String pin;
    private double balance;

    // Store accounts using a HashMap (accountNumber -> Account)
    private static Map<Long, Account> accounts = new HashMap<>();

    // Initialize test accounts in a static block
    static {
        accounts.put(13970100160661L, new Account(13970100160661L, "2025", 100000));
        accounts.put(12345678901234L, new Account(12345678901234L, "1234", 50000));
    }

    public Account(Long accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public Long getAccountNumber() { return accountNumber; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public static Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
    }

    public static void updateAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }
}
