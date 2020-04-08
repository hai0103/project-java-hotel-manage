package com.example.demo.dtos.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomSearchDTO extends BaseSearchDTO {
	private String roomNo;
	private Integer roomTypeId;
	private String status;
	private String statusStay;
	private Integer nop;
}
