package com.example.demo.services;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.example.demo.dtos.BookRoomDTO;
import com.example.demo.entities.BookRoomEntity;
import com.example.demo.entities.RoomEntity;

public abstract class BookRoomService implements IBaseService<BookRoomEntity, BookRoomDTO> {
	public abstract Page<BookRoomEntity> search(
			String bookNo, 
			String customerName, 
			String identity, 
			Date startDate, 
			Date endDate,
			String customerCode,
			Integer page, 
			Integer size);

	public abstract Object createBookRoom(int[] ids, int id);
	
	public abstract int updateBookRoom(int id);
}
