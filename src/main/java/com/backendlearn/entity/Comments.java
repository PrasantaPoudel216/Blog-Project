package com.backendlearn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;


@Entity
@Table(name="comments")
public class Comments {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="comment", nullable=false, length=1000)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="users_id",nullable=false)
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="post_id",nullable=false)
	private Post post;

	public Integer getId() {
		return id;
	}

	public void setId(Integer commentId) {
		this.id = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
	
}
