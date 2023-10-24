package com.vijayi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayi.entities.Comment;
import com.vijayi.entities.User;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
    List<Comment> findByPostedByUser(User user);
}

