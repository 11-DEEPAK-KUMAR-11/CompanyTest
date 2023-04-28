package com.bankApp.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankApp.models.Account;
import com.bankApp.models.User;
import com.bankApp.service.AccountService;
import com.bankApp.service.CreditService;
import com.bankApp.service.DebitService;
import com.bankApp.service.UserService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private CreditService creditService;

	@Autowired
	private DebitService debitService;

	@Autowired
	private AccountService aService;

	// Add account with users handler
	@PostMapping("/account")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {

		Account addedAccount = aService.addAccount(account);

		return new ResponseEntity<>(addedAccount, HttpStatus.OK);
	}

	// Credit amount from account handler
	@PostMapping("/credit")
	public ResponseEntity<String> credit(@RequestParam Long userId, @RequestParam BigDecimal amount) {

		creditService.credit(userId, amount);
		String msg = "Amount Rs." + amount + " Credited to user Id " + userId;

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	// Debit amount from account handler
	@PostMapping("/debit")
	public ResponseEntity<String> debit(@RequestParam Long userId, @RequestParam BigDecimal amount) {

		debitService.debit(userId, amount);
		String msg = "Amount Rs." + amount + " Debited from user Id " + userId;

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
