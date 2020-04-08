package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dtos.DeviceDTO;
import com.example.demo.entities.DeviceEntity;

public abstract class DeviceService implements IBaseService<DeviceEntity, DeviceDTO> {
	
	//public abstract Page<DeviceEntity> search(String roomNo, Integer roomTypeId, String status, String statusStay, Integer nop, Integer page, Integer size);

}
