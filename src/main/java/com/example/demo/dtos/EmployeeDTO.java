package com.example.demo.dtos;

import java.util.Date;

import com.example.demo.entities.EmployeeEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
	private String name;
	private String no;
	private Boolean gender;
	private String address;
	private String email;
	private String identity_card;
	private Date dob;
	
	public EmployeeEntity createEntity() {
		EmployeeEntity employee = new EmployeeEntity();
		employee.setName(this.name);
		employee.setNo(this.no);
		employee.setGender(this.gender);
		employee.setAddress(this.address);
		employee.setEmail(this.email);
		employee.setIdentity_card(this.identity_card);
		employee.setDob(this.dob);
		return employee;
	}
	
	public EmployeeEntity updateEntity(EmployeeEntity employee) {
		employee.setName(this.name);
		employee.setNo(this.no);
		employee.setGender(this.gender);
		employee.setAddress(this.address);
		employee.setEmail(this.email);
		employee.setIdentity_card(this.identity_card);
		employee.setDob(this.dob);
		return employee;
	}
}