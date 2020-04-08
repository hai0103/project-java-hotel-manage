package com.example.demo.dtos;

public class ResponseDataDTO<T> {
	
	private int code;
	private String message;
	private T data;
	
	public ResponseDataDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseDataDTO(int code, String message, T data) {
		this.code = code ; 
		this.message = message;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
