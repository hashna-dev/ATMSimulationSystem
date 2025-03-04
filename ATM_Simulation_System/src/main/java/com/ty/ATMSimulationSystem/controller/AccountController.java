package com.ty.mySpringBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.mySpringBank.model.Account;
import com.ty.mySpringBank.model.Transaction;
import com.ty.mySpringBank.service.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService service;

	@RequestMapping("/create")
	public String showCreateAccount(Model model) {
		model.addAttribute("account", new Account());
		return "create-account";
	}

	@PostMapping("/create")
	public String showCreateAccount(@ModelAttribute Account account) {
		service.createAccount(account);
		return "redirect:/accounts/create";
	}

	@GetMapping("/deposit")
	public String showDepositForm() {
		return "deposit";
	}

	@PostMapping("/deposit")
	public String deposit(@RequestParam String accountNumber, @RequestParam double amount) {
	    service.deposit(accountNumber, amount);
		return "redirect:/accounts/deposit";
	}

	@GetMapping("/withdraw")
	public String showWithdrawForm() {
		return "withdraw";
	}

	@PostMapping("/withdraw")
	public String withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
	    service.withdraw(accountNumber, amount);
		return "redirect:/accounts/withdraw";
	}
	@GetMapping("/history")
	public String showTransactionForm( ) {
		return "history";
	}
	@PostMapping("/history")
	public String TransactionForm(@RequestParam String accountNumber , Model model) {
		List<Transaction> transactions=service.getTransactions(accountNumber);
		model.addAttribute("transactions", transactions);
		return "getTransactions";
	}

}
