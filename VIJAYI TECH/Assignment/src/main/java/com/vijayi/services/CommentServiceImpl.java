package com.vijayi.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayi.entities.Comment;
import com.vijayi.entities.User;
import com.vijayi.repositories.CommentRepository;
import com.vijayi.repositories.UserRepository;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CommentRepository commentRepository;
	
	@Override
	public void addComment(String commentFrom, String commentTo, String message) {

	    
	    String sender, receiver;
	    if (commentFrom.compareTo(commentTo) < 0) {
	        sender = commentFrom;
	        receiver = commentTo;
	    } else {
	        sender = commentTo;
	        receiver = commentFrom;
	    }

	    User userTo = userRepository.findByCommentTo(receiver);
	    if (userTo == null) {
	        userTo = new User();
	        userTo.setCommentFrom(sender);
	        userTo.setCommentTo(receiver);
	        userRepository.save(userTo);
	    }

	    User userFrom = userRepository.findByCommentFrom(sender);
	    if (userFrom == null) {
	        userFrom = new User();
	        userFrom.setCommentFrom(sender);
	        userFrom.setCommentTo(receiver);
	        userRepository.save(userFrom);
	    }

	    Comment comment = new Comment();
	    comment.setMessage(message);
	    comment.setCommentDateTime(LocalDateTime.now());
	    comment.setPostedByUser(userFrom);
	    commentRepository.save(comment);

	  
	}




	
	@Override
	public List<Comment> getComments(String commentTo) {
	    List<Comment> comments = new ArrayList<>();

	    User userTo = userRepository.findByCommentTo(commentTo);
	    if (userTo != null) {
	        List<Comment> commentsTo = commentRepository.findByPostedByUser(userTo);
	        comments.addAll(commentsTo);
	    }

	    User userFrom = userRepository.findByCommentFrom(commentTo);
	    if (userFrom != null) {
	        List<Comment> commentsFrom = commentRepository.findByPostedByUser(userFrom);
	        comments.addAll(commentsFrom);
	    }

	    return comments;
	}


	
	
//	@Override
//	public List<Comment> getComments(String commentTo) {
//		
//		User user = userRepository.findByCommentTo(commentTo);
//        if (user != null) {
//            return commentRepository.findByPostedByUser(user);
//        }
//        return Collections.emptyList();
//	}

}
