package com.example.demo.dtos;

import java.util.Date;

import com.example.demo.entities.PaymentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
	private String no;
	private Date created_date;
	private Float total_cost;
	
	public PaymentEntity createEntity() {
		PaymentEntity payment = new PaymentEntity();
		payment.setNo(this.no);
		payment.setCreated_date(this.created_date);
		payment.setTotal_cost(this.total_cost);
		return payment;
	}
	
	public PaymentEntity updateEntity(PaymentEntity payment) {
		payment.setNo(this.no);
		payment.setCreated_date(this.created_date);
		payment.setTotal_cost(this.total_cost);
		return payment;
	}
}