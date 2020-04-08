package com.example.demo.dtos.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseSearchDTO {
	private int page;
	
	private int size;
}