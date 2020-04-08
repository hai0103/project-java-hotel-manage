package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.config.Views;
import com.example.demo.utils.ColumnDefinitionConstant;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_payment")
public class PaymentEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_payment_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
	@JsonView(Views.Public.class)
	private int id;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_no", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String no;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_created_date", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date created_date;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_total_cost", columnDefinition = ColumnDefinitionConstant.FLOAT)
	private Float total_cost;
}
