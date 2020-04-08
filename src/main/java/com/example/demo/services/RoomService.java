package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dtos.RoomDTO;
import com.example.demo.entities.RoomEntity;

public abstract class RoomService implements IBaseService<RoomEntity, RoomDTO> {
	
	public abstract Page<RoomEntity> search(String roomNo, Integer roomTypeId, String status, String statusStay, Integer nop, Integer page, Integer size);

}
