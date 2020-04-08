package com.example.demo.dtos;

import com.example.demo.entities.DeviceEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDTO {
	private String name;
	private String no;
	
	public DeviceEntity createEntity() {
		DeviceEntity device = new DeviceEntity();
		device.setName(this.name);
		device.setNo(this.no);
		return device;
	}
	
	public DeviceEntity updateEntity(DeviceEntity device) {
		device.setName(this.name);
		device.setNo(this.no);
		return device;
	}
}
