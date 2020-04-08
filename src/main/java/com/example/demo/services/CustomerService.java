package com.example.demo.services;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.example.demo.dtos.CustomerDTO;
import com.example.demo.entities.CustomerEntity;

public abstract class CustomerService implements IBaseService<CustomerEntity, CustomerDTO> {
	public abstract Page<CustomerEntity> search(
			String customerName, 
			String customerNo, 
			String nation, 
			String identityCard,
			Date dob,
			String phone,
			String email,
			Integer page, 
			Integer size);
}
