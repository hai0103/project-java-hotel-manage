package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dtos.PaymentDTO;
import com.example.demo.entities.PaymentEntity;

public abstract class PaymentService implements IBaseService<PaymentEntity, PaymentDTO> {
	
	//public abstract Page<DeviceEntity> search(String roomNo, Integer roomTypeId, String status, String statusStay, Integer nop, Integer page, Integer size);

}