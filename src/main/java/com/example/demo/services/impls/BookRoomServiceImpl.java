package com.example.demo.services.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BookRoomDTO;
import com.example.demo.entities.BookRoomEntity;
import com.example.demo.entities.RoomEntity;
import com.example.demo.repository.BookRoomRepository;
import com.example.demo.services.BookRoomService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.RoomService;

@Service
public class BookRoomServiceImpl extends BookRoomService {
	
	@Autowired
	BookRoomRepository repository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RoomService roomService;

	@Override
	public BookRoomEntity create(BookRoomDTO dto) {
		// TODO Auto-generated method stub
		BookRoomEntity entity = dto.createEntity();
		entity.setCustomer(customerService.get(dto.getCustomerId()));
		return repository.save(entity);
	}
	
	@Override
	public Object createBookRoom(int[] ids, int id) {
		BookRoomEntity bookRoom = get(id);
		for(int item: ids) {
			RoomEntity entity = roomService.get(item);
			entity.setStatusStay("Đang sử dụng");
			entity.getBookRooms().add(bookRoom);
			bookRoom.getRooms().add(entity);
			repository.save(bookRoom);
		}
		return 0;
	}
	
	@Override
	public BookRoomEntity get(int id) {
		// TODO Auto-generated method stub
		Optional<BookRoomEntity> bookRoomOptional = repository.findById(id);
		if (!bookRoomOptional.isPresent()) {
			throw new RuntimeException("Không tìm thấy book room!");
		}
		return bookRoomOptional.get();
	}

	@Override
	public List<BookRoomEntity> all() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public BookRoomEntity update(int id, BookRoomDTO dto) {
		// TODO Auto-generated method stub
		BookRoomEntity entity = get(id);
		return repository.save(dto.updateEntity(entity));
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id: ids) {
			BookRoomEntity entity = get(id);
			entity.getRooms().forEach((room)->{
				room.setStatusStay("TRỐNG");
			});
			entity.getRooms().clear();
			repository.delete(entity);
		}
		return 0;
	}

	@Override
	public Page<BookRoomEntity> search(String bookNo, String customerName, String identity, Date startDate,
			Date endDate, String customerCode, Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBookRoom(int id) {
		// TODO Auto-generated method stub
		BookRoomEntity entity = get(id);
		entity.setStatus(1);
		entity.getRooms().forEach((activity)->{
			activity.setStatusStay("TRỐNG");
		});
		repository.save(entity);
		return 0;
	}
	
}
