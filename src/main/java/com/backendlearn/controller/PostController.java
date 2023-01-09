package com.backendlearn.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backendlearn.dto.PostDto;
import com.backendlearn.payloads.Response;
import com.backendlearn.services.PostService;
import com.backendlearn.utils.UsersMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PostController implements UsersMessage {

	@Autowired
	PostService postService;

	private static Logger logger = LoggerFactory.getLogger(PostController.class);

	// to insert post
	@PostMapping(value = "/insertpost/{userId}/{categoryId}")
	public Response insertPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId// @RequestParam (value="id",required=false,defaultValue) Integer id
	) {
		Response response = new Response();
		response.setMessage(DATA_SAVED);
		response.setObject((postService.createPost(postDto, userId, categoryId)));
		response.setState(true);

		
		if(logger.isDebugEnabled())
		{
			logger.debug(PostController.class+"insertPost");
		}
		return response;
	}

	// to update post
	@PutMapping(value = "/updatepost/{postId}")
	public Response updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		Response response = new Response();

		response.setMessage(DATA_UPDATED);
		response.setObject((postService.updatePost(postDto, postId)));
		response.setState(true);

		return response;

	}

	// to get all post
	@GetMapping(value = "/getallpost")
	public Response getAllPost() {
		Response response = new Response();

		response.setObject((postService.getAllPosts()));
		response.setMessage(DATA_FOUND);
		response.setState(true);

		return response;
	}

	// to get post by id
	@GetMapping(value = "/getpostbyid/{postId}")
	public Response getPostById(@PathVariable Integer postId) {
		Response response = new Response();

		response.setObject((postService.getPostById(postId)));
		response.setMessage(DATA_FOUND);
		response.setState(true);

		return response;

	}

	// to get post with pagination

	@GetMapping(value = "/getpostsbypagination",params={"page","size","sortby"})
	public Response getPostsByPagination(@RequestParam (value="page",required=false,defaultValue="0") Integer page, @RequestParam (value="size",required=false,defaultValue="1") Integer size,
			@RequestParam (value="sortby",required=false,defaultValue="title") String sortBy) {
		
		if(logger.isDebugEnabled())
		{
			logger.debug(PostController.class+"getPostByPagination");
		}
		Response response = new Response();

		response.setObject((postService.getPostWithPagination(page, size,sortBy)));
		response.setMessage(DATA_FOUND);
		response.setState(true);

		return response;
	}

	// to get post by user
	@GetMapping(value = "/getbyuser/{userId}")
	public Response getByUser(@PathVariable Integer userId) {
		Response response = new Response();
		response.setObject((postService.getPostByUsers(userId)));
		response.setMessage(DATA_FOUND);
		response.setState(true);

		return response;
	}

	// to get post by category
	@GetMapping(value = "/getbycategory/{categoryId}")
	public Response getByCategory(@PathVariable Integer categoryId) {
		Response response = new Response();
		response.setObject((postService.getPostByCategory(categoryId)));
		response.setMessage(DATA_FOUND);
		response.setState(true);
		return response;
	}

	
	@GetMapping(value="/searchpost/{keyword}")
	public Response searchPos(@PathVariable String keyword)
	{
	if(logger.isDebugEnabled())
	{
		logger.debug(PostController.class+"searchpost");
	}
	Response response=new Response();
		
		response.setObject(postService.searchPost(keyword));
		response.setMessage(DATA_FOUND);
		response.setState(true);
		
		return response;
	}
	
	@DeleteMapping(value = "/deletepost/{postId}")
	public Response deletePost(@PathVariable Integer postId) {
		Response response = new Response();
		postService.deletePost(postId);
		response.setMessage(DATA_DELETED);
		response.setState(true);

		return response;
	}

}
