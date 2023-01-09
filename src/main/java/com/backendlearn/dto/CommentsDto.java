package com.backendlearn.dto;

import javax.persistence.Column;

public class CommentsDto {
	private Integer id;
	private String comment;
	
	private PostDto postDto;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PostDto getPostDto() {
		return postDto;
	}

	public void setPostDto(PostDto postDto) {
		this.postDto = postDto;
	}

	
	
}
