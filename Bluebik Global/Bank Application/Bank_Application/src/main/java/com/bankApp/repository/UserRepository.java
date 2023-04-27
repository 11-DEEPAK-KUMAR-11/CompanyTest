package com.bankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankApp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
}
