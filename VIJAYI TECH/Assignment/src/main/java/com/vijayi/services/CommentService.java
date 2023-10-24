package com.vijayi.services;

import java.util.List;

import com.vijayi.entities.Comment;

public interface CommentService {

	public void addComment(String commentFrom, String commentTo, String message);
	
	public List<Comment> getComments(String commentTo);
}
