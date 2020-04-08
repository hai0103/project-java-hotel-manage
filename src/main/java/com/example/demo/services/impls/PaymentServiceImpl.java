package com.example.demo.services.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.PaymentDTO;
import com.example.demo.entities.PaymentEntity;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.services.PaymentService;

@Service
public class PaymentServiceImpl extends PaymentService {
	
	@Autowired
	PaymentRepository repository;
	
	@Override
	public PaymentEntity create(PaymentDTO dto) {
		// TODO Auto-generated method stub
		return repository.save(dto.createEntity());
	}

	@Override
	public PaymentEntity get(int id) {
		// TODO Auto-generated method stub
		Optional<PaymentEntity> optional = repository.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("Không tìm thấy Device!");
		}
		return optional.get();
	}

	@Override
	public List<PaymentEntity> all() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public PaymentEntity update(int id, PaymentDTO dto) {
		// TODO Auto-generated method stub
		PaymentEntity entity = get(id);
		entity = dto.updateEntity(entity);
	
		return repository.save(entity);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id: ids) {
			PaymentEntity entity = get(id);
			repository.delete(entity);
		}
		return 0;
	}

//	@Override
//	public Page<PaymentEntity> search(String DeviceName, String DeviceNo, String nation, String identityCard,
//			Date dob, String phone, String email, Integer page, Integer size) {
//		// TODO Auto-generated method stub
//		return repository.search(DeviceName,DeviceNo, nation, identityCard, dob, phone, email, PageRequest.of(page,size));
//	}	

}