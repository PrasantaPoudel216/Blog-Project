package com.backendlearn.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.backendlearn.dto.PostDto;
import com.backendlearn.entity.Category;
import com.backendlearn.entity.Post;
import com.backendlearn.entity.Users;
import com.backendlearn.exceptions.ResourceNotFoundException;
import com.backendlearn.payloads.PaginationResponse;
import com.backendlearn.repository.CategoryRepo;
import com.backendlearn.repository.PostRepo;
import com.backendlearn.repository.Usersrepo;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepo postRepo;

	@Autowired
	Usersrepo usersRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ModelMapper modelMapper;

	private static Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		if (logger.isDebugEnabled()) {
			logger.debug(PostServiceImpl.class + "createPost");
		}

		Post post = modelMapper.map(postDto, Post.class);
		Optional<Users> users = usersRepo.findById(userId);
		Users user = users.get();

		Optional<Category> categorys = categoryRepo.findById(categoryId);// .orElseThrow(()->new
																			// ResourceNotFoundException("users", "" //
																			// userId));
		Category category = categorys.get();
		post.setUsers(user);
		post.setCategory(category);
		post.setImageName("default.png");
		post.setAddedDate(new Date());

		return modelMapper.map((postRepo.save(post)), PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(postId).orElseThrow();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setAddedDate(postDto.getAddedDate());
		post.setImageName(postDto.getImageName());

		return modelMapper.map((postRepo.save(post)), PostDto.class);
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> postLists = postRepo.findAll();
		List<PostDto> postDtoLists = new ArrayList<>();

		for (Post post : postLists) {
			postDtoLists.add((modelMapper.map(post, PostDto.class)));

		}
		return postDtoLists;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = postRepo.findById(postId).orElseThrow();

		return (modelMapper.map(post, PostDto.class));
	}

	@Override
	public void deletePost(Integer postId) {
		postRepo.deleteById(postId);

	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {

		Category category = categoryRepo.findById(categoryId).orElseThrow();

		List<Post> postLists = postRepo.findByCategory(category);
		List<PostDto> postDtoLists = new ArrayList<>();

		for (Post post : postLists) {
			postDtoLists.add(modelMapper.map(post, PostDto.class));
		}

		return postDtoLists;
	}

	@Override
	public List<PostDto> getPostByUsers(Integer usersId) {

		Users users = usersRepo.findById(usersId).orElseThrow();
//		Pageable p=PageRequest.of(0,4);
//		Page<Post> postListss=this.postRepo.findByUsers(p,users);
//		List<Post>postLists=postListss.getContent();
		
		List<Post> postLists = postRepo.findByUsers(users);
		
		
		List<PostDto> postDtoLists = new ArrayList<>();
		for (Post post : postLists) {
			postDtoLists.add((modelMapper.map(post, PostDto.class)));

		}

		return postDtoLists;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
	
		List<Post> postLists=postRepo.findByTitle(keyword);
		List<PostDto> postDtoLists=new ArrayList<>();
		
		if(postDtoLists.isEmpty())
		{
			System.out.println("khali xa k garne ho sarakar");
			System.out.println(keyword);
		}
		
		for(Post post:postLists)
		{
			postDtoLists.add((modelMapper.map(post,PostDto.class)));
			System.out.println(post.getContent()+"came hi");
			System.out.println(post.getTitle());
		}
		
		
		return postDtoLists;
	}

	@Override
	public PaginationResponse getPostWithPagination(Integer page, Integer size,String sortBy) {
		if (logger.isDebugEnabled()) {
			logger.debug(PostServiceImpl.class + "getPostWithPagination");
		}

		PaginationResponse paginationResponse = new PaginationResponse();
		Pageable p = PageRequest.of(page, size,Sort.by(sortBy));

		Page<Post> post = postRepo.findAll(p);
		List<Post> postLists = post.getContent();
		List<PostDto> postDtoLists = new ArrayList<>();
		for (Post postDto : postLists) {
			postDtoLists.add((modelMapper.map(postDto, PostDto.class)));
		}
		paginationResponse.setContent(postDtoLists);
		paginationResponse.setPageNo(post.getNumber());
		paginationResponse.setPageSize(post.getSize());
		paginationResponse.setTotalElements(post.getNumberOfElements());
		paginationResponse.setTotalPages(post.getTotalPages());
		paginationResponse.setLastPage(post.isLast());

		return paginationResponse;
	}

}
