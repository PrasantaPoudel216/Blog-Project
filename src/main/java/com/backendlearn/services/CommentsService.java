package com.backendlearn.services;

import org.springframework.stereotype.Service;

import com.backendlearn.dto.CommentsDto;

@Service
public interface CommentsService {
	
	//create comment
	public CommentsDto createComment(CommentsDto commentsDto,Integer postId,Integer usersId);
	
	//delete comment
	public void deleteComment(Integer commentId);

}
