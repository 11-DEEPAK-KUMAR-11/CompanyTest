package com.bankApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.models.User;
import com.bankApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
    
    public User addUser(User user) {
    	
    	
        
        return userRepository.save(user);
    }
}
