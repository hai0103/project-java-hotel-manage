package com.example.demo.dtos;
import com.example.demo.entities.RoomEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO{

	private String name;
	private String no;
	private Integer nop;
	private Float price;
	private String status;
	private String statusStay;
	private Integer numpeople;
	private Integer typeroomId;
	
		
	public RoomEntity createEntity() {
		RoomEntity room = new RoomEntity();
		room.setName(this.name);
		room.setNo(this.no);
		room.setNop(this.nop);
		room.setPrice(this.price);
		room.setStatus(this.status);
		room.setStatusStay(this.statusStay);
		room.setNumpeople(this.numpeople);
		return room;
	}
	
	public RoomEntity updateEntity(RoomEntity room) {
		room.setName(this.name);
		room.setNo(this.no);
		room.setNop(this.nop);
		room.setPrice(this.price);
		room.setStatus(this.status);
		room.setStatusStay(this.statusStay);
		room.setNumpeople(this.numpeople);
		return room;
	}
}