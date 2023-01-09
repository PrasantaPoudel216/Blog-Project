package com.backendlearn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.backendlearn.entity.Category;
import com.backendlearn.entity.Post;
import com.backendlearn.entity.Users;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	public List<Post> findByCategory(Category category);
	public List<Post> findByUsers(Users users);
	//public Page findByUsers(Pageable p,Users users);
	public List<Post>findByTitle(String keyword);

	

}
