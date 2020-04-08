package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.PostEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto{

	private String title;
	
	private String description;
		
	public PostEntity createPostEntity() {
		PostEntity post = new PostEntity();
		post.setTitle(this.title);
		post.setDescription(this.description);
		return post;
	}
	
	public PostEntity updatePostEntity(PostEntity post) {
		post.setTitle(this.title);
		post.setDescription(this.description);
		return post;
	}
}