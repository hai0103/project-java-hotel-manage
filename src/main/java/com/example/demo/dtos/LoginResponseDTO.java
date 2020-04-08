package com.example.demo.dtos;

import com.example.demo.entities.UserEntity;

import lombok.Data;

@Data
public class LoginResponseDTO {
	private String accessToken;
    private String tokenType = "Bearer";
    private Object user;

    public LoginResponseDTO(String accessToken, Object user) {
        this.accessToken = accessToken;
        this.user = user;
    }
}
