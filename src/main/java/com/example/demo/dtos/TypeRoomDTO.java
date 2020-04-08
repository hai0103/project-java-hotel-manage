package com.example.demo.dtos;
import com.example.demo.entities.TypeRoomEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeRoomDTO{

	private String name;
	private String description;
	private Float price;
		
	public TypeRoomEntity createEntity() {
		TypeRoomEntity entity = new TypeRoomEntity();
		entity.setName(this.name);
		entity.setDescription(this.description);
		entity.setPrice(this.price);
		return entity;
	}
	
	public TypeRoomEntity updateEntity(TypeRoomEntity entity) {
		entity.setName(this.name);
		entity.setDescription(this.description);
		entity.setPrice(this.price);
		return entity;
	}
}