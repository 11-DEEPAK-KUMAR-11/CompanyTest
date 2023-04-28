package com.bankApp.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.models.Account;
import com.bankApp.models.User;
import com.bankApp.repository.AccountRepository;
import com.bankApp.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CreditService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void credit(Long userId, BigDecimal amount) {

		User user = userRepository.findById(userId).orElseThrow();

		Account account = user.getAccount();

		BigDecimal newBalance = account.getBalance().add(amount);

		BigDecimal limit = new BigDecimal("10000000");

		if (newBalance.compareTo(limit) > 0) {

			throw new RuntimeException("Account balance cannot go beyond 10 million");
		}

		account.setBalance(newBalance);
		accountRepository.save(account);
	}
}
