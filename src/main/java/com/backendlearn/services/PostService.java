package com.backendlearn.services;

import org.springframework.stereotype.Service;
import java.util.List;

import com.backendlearn.dto.PostDto;
import com.backendlearn.entity.Category;
import com.backendlearn.entity.Post;
import com.backendlearn.entity.Users;
import com.backendlearn.payloads.PaginationResponse;

@Service
public interface PostService {

	// create post
	public PostDto createPost(PostDto postDto, Integer userId, Integer CategoryId);

	// update post
	public PostDto updatePost(PostDto postDto, Integer postId);

	// get all post
	public List<PostDto> getAllPosts();

	// get single post
	public PostDto getPostById(Integer postId);
	
	//get post with pagination
	public PaginationResponse getPostWithPagination(Integer page,Integer size,String sortBy);

	// get post by category
	public List<PostDto> getPostByCategory(Integer categoryId);

	// get post by users
	public List<PostDto> getPostByUsers(Integer usersId);

	// search post by keyword
	List<PostDto> searchPost(String keyword);

	// delete post
	public void deletePost(Integer postId);
	
	

}
