package com.example.demo.services.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CustomerDTO;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;

@Service
public class CustomerServiceImpl extends CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	@Override
	public CustomerEntity create(CustomerDTO dto) {
		// TODO Auto-generated method stub
		return repository.save(dto.createEntity());
	}

	@Override
	public CustomerEntity get(int id) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> customerOptional = repository.findById(id);
		if (!customerOptional.isPresent()) {
			throw new RuntimeException("Không tìm thấy customer!");
		}
		return customerOptional.get();
	}

	@Override
	public List<CustomerEntity> all() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public CustomerEntity update(int id, CustomerDTO dto) {
		// TODO Auto-generated method stub
		CustomerEntity entity = get(id);
		entity = dto.updateEntity(entity);
	
		return repository.save(entity);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		for(int id: ids) {
			CustomerEntity entity = get(id);
			repository.delete(entity);
		}
		return 0;
	}

	@Override
	public Page<CustomerEntity> search(String customerName, String customerNo, String nation, String identityCard,
			Date dob, String phone, String email, Integer page, Integer size) {
		// TODO Auto-generated method stub
		return repository.search(customerName,customerNo, nation, identityCard, dob, phone, email, PageRequest.of(page,size));
	}	

}
