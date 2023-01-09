package com.backendlearn.repository;


import org.springframework.stereotype.Repository;

import com.backendlearn.entity.Comments;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CommentsRepo extends JpaRepository<Comments,Integer>{
	
	Comments findByComment(String comments);

}
