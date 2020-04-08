package com.example.demo.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.LoginRequestDTO;
import com.example.demo.dtos.LoginResponseDTO;
import com.example.demo.dtos.ResponseDataDTO;
import com.example.demo.filters.JwtTokenProvider;
import com.example.demo.utils.Constants;
import com.example.demo.entities.CustomUserDetails;
import com.example.demo.entities.UserEntity;

@RestController
@CrossOrigin
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping(value = "/login")
	public ResponseDataDTO<LoginResponseDTO> login(@RequestBody LoginRequestDTO user) {
		// Authentication from user name and password
		Authentication authentication = authenticationManager
											.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Object currentUser = authentication.getPrincipal();
		String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		
		ResponseDataDTO<LoginResponseDTO> response = new ResponseDataDTO<LoginResponseDTO>();
		response.setData(new LoginResponseDTO(jwt,currentUser));
		response.setMessage(Constants.SUCCESS);
		
		return response;
	}

}
