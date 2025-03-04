package com.ty.atm.controller;

import com.ty.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atm")
public class ATMController {
    @Autowired
    private ATMService atmService;

    @GetMapping("/")
    public String showLoginPage() {
        return "index";  // Loads index.html
    }

    @PostMapping("/menu")
    public String showMenu(@RequestParam Long accountNumber, @RequestParam String pin, Model model) {
        boolean isValid = atmService.validateAccount(accountNumber, pin);
        if (!isValid) {
            model.addAttribute("message", "Invalid Account Number or PIN");
            return "index"; // Redirect to login page
        }

        model.addAttribute("accountNumber", accountNumber);
        model.addAttribute("pin", pin);
        model.addAttribute("message", "Login successful!");
        return "menu"; // Show ATM menu page
    }

    @PostMapping("/check-balance")
    public String checkBalance(@RequestParam Long accountNumber, @RequestParam String pin, Model model) {
        double balance = atmService.checkBalance(accountNumber, pin);
        model.addAttribute("message", "Your balance: ₹" + balance);
        return "result";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accountNumber, @RequestParam String pin, @RequestParam double amount, Model model) {
        String message = atmService.deposit(accountNumber, pin, amount);
        model.addAttribute("message", message);
        return "result";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long accountNumber, @RequestParam String pin, @RequestParam double amount, Model model) {
        String message = atmService.withdraw(accountNumber, pin, amount);
        model.addAttribute("message", message);
        return "result";
    }
}
