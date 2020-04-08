package com.example.demo.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.PostDto;
import com.example.demo.entities.PostEntity;
import com.example.demo.repository.PostRepository;



@Service
public class PostService {
	
	@Autowired
	PostRepository repository;
	
	public PostEntity create(PostDto dto) {
		return repository.save(dto.createPostEntity());
	}
	
	public List<PostEntity> getAll() {
		return repository.findAll();
	}
	
	public PostEntity get(int id) {
		Optional<PostEntity> postOptional = repository.findById(id);
		if (!postOptional.isPresent()) {
			throw new RuntimeException("Không tìm thấy post!");
		}
		return postOptional.get();
	}
	
	public PostEntity update(int id, PostDto dto) {
		PostEntity entity = get(id);
		
		return repository.save(dto.updatePostEntity(entity));
	}
	
	public void delete(int id) {
		PostEntity entity = get(id);
		repository.delete(entity);
	}
}
