package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IBaseService<T, K> {
	T create(K dto);
	
	T get(int id);
	
	List<T> all();
	
	T update(int id, K dto);
	
	int delete(int[] ids);
}