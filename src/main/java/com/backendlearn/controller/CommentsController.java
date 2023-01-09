package com.backendlearn.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.backendlearn.dto.CommentsDto;
import com.backendlearn.payloads.Response;
import com.backendlearn.services.CommentsService;
import com.backendlearn.utils.UsersMessage;

@RestController
public class CommentsController implements UsersMessage {
	
	@Autowired
	CommentsService commentsService;
	
	
	//create comments
	@PostMapping(value="/insertcomment/{postId}/{userId}")
	public Response insertComment(@RequestBody CommentsDto commentsDto,@PathVariable Integer postId,@PathVariable Integer userId)
	{
	Response response =new Response();
		
		response.setMessage(DATA_SAVED);
		response.setState(true);
		response.setObject(commentsService.createComment(commentsDto,postId,userId));
		
		return response;
		
	}
	
	
	//delete comments
	@DeleteMapping(value="/deletecomment/{commentId}")
	public void deleteComment(@PathVariable Integer commentId)
	{
		commentsService.deleteComment(commentId);
	}

}
