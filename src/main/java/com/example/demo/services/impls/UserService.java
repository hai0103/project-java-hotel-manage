package com.example.demo.services.impls;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CustomUserDetails;
import com.example.demo.entities.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserEntity user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

	@Transactional
	public UserDetails loadUserById(Integer id) {
		UserEntity user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));

		return new CustomUserDetails(user);
	}
}