package com.example.demo.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.TypeRoomDTO;
import com.example.demo.entities.TypeRoomEntity;
import com.example.demo.repository.TypeRoomRepository;
import com.example.demo.services.TypeRoomService;

@Service
public class TypeRoomServiceImpl extends TypeRoomService {

	@Autowired
	TypeRoomRepository repository;
	
	@Override
	public List<TypeRoomEntity> all(){
		return repository.findAll();
	}
	
	@Override
	public TypeRoomEntity create(TypeRoomDTO dto) {
		// TODO Auto-generated method stub
		return repository.save(dto.createEntity());
	}
	
	@Override
	public TypeRoomEntity get(int id) {
		// TODO Auto-generated method stub
		Optional<TypeRoomEntity> typeRoomOptional = repository.findById(id);
		if (!typeRoomOptional.isPresent()) {
			throw new RuntimeException("Không tìm thấy typeroom!");
		}
		return typeRoomOptional.get();
	}

	@Override
	public TypeRoomEntity update(int id, TypeRoomDTO dto) {
		// TODO Auto-generated method stub
		TypeRoomEntity entity = get(id);
		
		return repository.save(dto.updateEntity(entity));
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id: ids) {
			TypeRoomEntity entity = get(id);
			repository.delete(entity);
		}
		return 0;
	}

	@Override
	public Page<TypeRoomEntity> search(String name, String description, Integer page, Integer size) {
		// TODO Auto-generated method stub
		return repository.search(name, description, PageRequest.of(page,size));
	}


}
