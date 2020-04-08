package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name="tbl_employee")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_employee_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
	@JsonView(Views.Public.class)
	private int id;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_name", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String name;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_no", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String no;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_gender", columnDefinition = ColumnDefinitionConstant.BIT)
	private Boolean gender;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_address", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String address;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_email", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String email;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_identity_card", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String identity_card;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_dob", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date dob;
	
}
