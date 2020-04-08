package com.example.demo.dtos;

import java.util.Date;

import com.example.demo.entities.CustomerEntity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerDTO {
	private String name;
	private String no;
	private Boolean gender;
	private String address;
	private String phone;
	private String email;
	private String identity_card;
	private String nationality;
	private Date dob;
	private Date created_date;
	
	public CustomerEntity createEntity() {
		CustomerEntity entity = new CustomerEntity();
		entity.setName(this.name);
		entity.setNo(this.no);
		entity.setGender(this.gender);
		entity.setAddress(this.address);
		entity.setPhone(this.phone);
		entity.setEmail(this.email);
		entity.setIdentity_card(this.identity_card);
		entity.setNationality(this.nationality);
		entity.setDob(this.dob);
		entity.setCreated_date(this.created_date);
		return entity;
	}
	
	public CustomerEntity updateEntity(CustomerEntity entity) {
		entity.setName(this.name);
		entity.setNo(this.no);
		entity.setGender(this.gender);
		entity.setAddress(this.address);
		entity.setPhone(this.phone);
		entity.setEmail(this.email);
		entity.setIdentity_card(this.identity_card);
		entity.setNationality(this.nationality);
		entity.setDob(this.dob);
		entity.setCreated_date(this.created_date);
		return entity;
	}
}
