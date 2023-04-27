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
public class DebitService {

	    @Autowired
	    private AccountRepository accountRepository;
	    
	    @Autowired
	    private UserRepository userRepository;
	    
	    @Transactional
	    public void debit(Long userId, BigDecimal amount) {
	    	
	        User user = userRepository.findById(userId).orElseThrow();
	        
	        Account account = user.getAccount();
	        
	        BigDecimal newBalance = account.getBalance().subtract(amount);
	        
	        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
	        	
	            throw new RuntimeException("Account balance cannot go below 0");
	            
	        }
	        account.setBalance(newBalance);
	        accountRepository.save(account);
	    }
}
