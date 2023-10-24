package com.vijayi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    public User findByCommentTo(String commentTo);

	public User findByCommentFrom(String commentFrom);
}



