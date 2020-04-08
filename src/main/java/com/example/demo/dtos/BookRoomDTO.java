package com.example.demo.dtos;
import java.util.Date;

import com.example.demo.entities.BookRoomEntity;
import com.example.demo.entities.RoomEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRoomDTO{
	private String bookNo;
	private Date start_date;
	private Date end_date;
	private Date created_date;
	private Integer status;
	private Float deposit;
	private Integer customerId;
		
	public BookRoomEntity createEntity() {
		BookRoomEntity entity = new BookRoomEntity();
		entity.setBookNo(this.bookNo);
		entity.setStart_date(this.start_date);
		entity.setEnd_date(this.end_date);
		entity.setCreated_date(this.created_date);
		entity.setStatus(this.status);
		entity.setDeposit(this.deposit);
		return entity;
	}
	
	public BookRoomEntity updateEntity(BookRoomEntity entity) {
		entity.setBookNo(this.bookNo);
		entity.setStart_date(this.start_date);
		entity.setEnd_date(this.end_date);
		entity.setCreated_date(this.created_date);
		entity.setStatus(this.status);
		entity.setDeposit(this.deposit);
		return entity;
	}
}