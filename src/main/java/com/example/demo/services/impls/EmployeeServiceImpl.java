package com.example.demo.services.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeService;

@Service
public class EmployeeServiceImpl extends EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	@Override
	public EmployeeEntity create(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return repository.save(dto.createEntity());
	}

	@Override
	public EmployeeEntity get(int id) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> optional = repository.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("Không tìm thấy Employee!");
		}
		return optional.get();
	}

	@Override
	public List<EmployeeEntity> all() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public EmployeeEntity update(int id, EmployeeDTO dto) {
		// TODO Auto-generated method stub
		EmployeeEntity entity = get(id);
		entity = dto.updateEntity(entity);
	
		return repository.save(entity);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id: ids) {
			EmployeeEntity entity = get(id);
			repository.delete(entity);
		}
		return 0;
	}

}
