package com.example.demo.services.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.DeviceDTO;
import com.example.demo.entities.DeviceEntity;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.services.DeviceService;

@Service
public class DeviceServiceImpl extends DeviceService {
	
	@Autowired
	DeviceRepository repository;
	
	@Override
	public DeviceEntity create(DeviceDTO dto) {
		// TODO Auto-generated method stub
		return repository.save(dto.createEntity());
	}

	@Override
	public DeviceEntity get(int id) {
		// TODO Auto-generated method stub
		Optional<DeviceEntity> DeviceOptional = repository.findById(id);
		if (!DeviceOptional.isPresent()) {
			throw new RuntimeException("Không tìm thấy Device!");
		}
		return DeviceOptional.get();
	}

	@Override
	public List<DeviceEntity> all() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public DeviceEntity update(int id, DeviceDTO dto) {
		// TODO Auto-generated method stub
		DeviceEntity entity = get(id);
		entity = dto.updateEntity(entity);
	
		return repository.save(entity);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id: ids) {
			DeviceEntity entity = get(id);
			repository.delete(entity);
		}
		return 0;
	}

//	@Override
//	public Page<DeviceEntity> search(String DeviceName, String DeviceNo, String nation, String identityCard,
//			Date dob, String phone, String email, Integer page, Integer size) {
//		// TODO Auto-generated method stub
//		return repository.search(DeviceName,DeviceNo, nation, identityCard, dob, phone, email, PageRequest.of(page,size));
//	}	

}
