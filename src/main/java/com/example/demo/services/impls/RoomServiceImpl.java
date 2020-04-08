package com.example.demo.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.RoomDTO;
import com.example.demo.entities.BookRoomEntity;
import com.example.demo.entities.RoomEntity;
import com.example.demo.repository.RoomRepository;
import com.example.demo.services.RoomService;
import com.example.demo.services.TypeRoomService;

@Service
public class RoomServiceImpl extends RoomService {
	
	@Autowired
	RoomRepository repository;
	
	@Autowired
	TypeRoomService typeService;
	
	@Override
	public RoomEntity create(RoomDTO dto) {
		RoomEntity entity = dto.createEntity();
		entity.setTyperoom(typeService.get(dto.getTyperoomId()));
		return repository.save(entity);
	}
	
	@Override
	public List<RoomEntity> all() {
		return repository.findAll();
	}
	
	@Override
	public RoomEntity get(int id) {
		Optional<RoomEntity> roomOptional = repository.findById(id);
		if (!roomOptional.isPresent()) {
			throw new RuntimeException("Không tìm thấy room!");
		}
		return roomOptional.get();
	}
	
	@Override
	public RoomEntity update(int id, RoomDTO dto) {
		RoomEntity entity = get(id);
		entity = dto.updateEntity(entity);
		entity.setTyperoom(typeService.get(dto.getTyperoomId()));
		
		return repository.save(entity);
	}
	
	@Override
	public int delete(int[] ids) {
		for(int id: ids) {
			RoomEntity entity = get(id);
			repository.delete(entity);
		}
		return 0;
	}
	
	@Override
	public Page<RoomEntity> search(String roomNo, Integer roomTypeId, String status, String statusStay, Integer nop, Integer page, Integer size) {
		// TODO Auto-generated method stub
		return repository.search(roomNo,roomTypeId, status, statusStay, nop, PageRequest.of(page,size));
	}

}
