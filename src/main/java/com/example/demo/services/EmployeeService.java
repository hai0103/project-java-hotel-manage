package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entities.EmployeeEntity;

public abstract class EmployeeService implements IBaseService<EmployeeEntity, EmployeeDTO> {
	
	//public abstract Page<DeviceEntity> search(String roomNo, Integer roomTypeId, String status, String statusStay, Integer nop, Integer page, Integer size);

}
