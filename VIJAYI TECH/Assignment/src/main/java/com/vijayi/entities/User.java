package com.vijayi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "Comment from cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Comment from should contain only alphabets")
    @Column(name = "comment_from", nullable = false)
    private String commentFrom;

    @NotBlank(message = "Comment to cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Comment to should contain only alphabets")
    @Column(name = "comment_to", nullable = false)
    private String commentTo;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String commentFrom, String commentTo) {
		super();
		this.userId = userId;
		this.commentFrom = commentFrom;
		this.commentTo = commentTo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCommentFrom() {
		return commentFrom;
	}

	public void setCommentFrom(String commentFrom) {
		this.commentFrom = commentFrom;
	}

	public String getCommentTo() {
		return commentTo;
	}

	public void setCommentTo(String commentTo) {
		this.commentTo = commentTo;
	}

    
    
    
    
    
}