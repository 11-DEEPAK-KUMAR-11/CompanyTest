package com.bankApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.models.Account;
import com.bankApp.models.User;
import com.bankApp.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
    private AccountRepository accountRepository;
    
    public Account addAccount(Account account) {
       
    	List<User> users = account.getUsers();
    	
    		account.setUsers(users);;
            
    		for(User user:users)
    		{
    			user.setAccount(account);
    		}
    	
        
        return accountRepository.save(account);
    }
    
}
