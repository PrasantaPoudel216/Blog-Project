package com.backendlearn.services;


import org.springframework.stereotype.Service;

import com.backendlearn.dto.CommentsDto;
import com.backendlearn.entity.Comments;
import com.backendlearn.entity.Post;
import com.backendlearn.entity.Users;
import com.backendlearn.repository.CommentsRepo;
import com.backendlearn.repository.PostRepo;
import com.backendlearn.repository.Usersrepo;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommentsServiceImpl implements CommentsService{
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private Usersrepo usersRepo;
	
	@Autowired
	ModelMapper modelMapper;

	private static Logger logger=LoggerFactory.getLogger(CommentsServiceImpl.class);
	
	@Override
	public CommentsDto createComment(CommentsDto commentsDto, Integer postId, Integer usersId) {
		
		if(logger.isDebugEnabled())
		{
			logger.debug(CommentsServiceImpl.class+"createComment");
		}
		
		Comments comments=modelMapper.map(commentsDto,Comments.class);
		
		Post post=postRepo.findById(postId).orElseThrow();
		Users users=usersRepo.findById(usersId).orElseThrow();
		
		comments.setPost(post);
		comments.setUser(users);
		
		return modelMapper.map((commentsRepo.save(comments)), CommentsDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		
		commentsRepo.deleteById(commentId);
		
	}
	
	
	
	

}
