package com.example.demo.services;

import org.springframework.data.domain.Page;

import com.example.demo.dtos.TypeRoomDTO;
import com.example.demo.entities.TypeRoomEntity;

public abstract class TypeRoomService implements IBaseService<TypeRoomEntity, TypeRoomDTO> {
	public abstract Page<TypeRoomEntity> search(String name, String description, Integer page, Integer size);
}