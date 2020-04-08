package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.config.Views;
import com.example.demo.utils.ColumnDefinitionConstant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_typeroom")
@JsonIgnoreProperties(value = { "rooms" })
public class TypeRoomEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_typeroom_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
//	@JsonView(Views.Public.class)
	private int id;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_name", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String name;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_description", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String description;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_price", columnDefinition = ColumnDefinitionConstant.FLOAT)
	private Float price;
	
//	@JsonView(Views.Public.class)
	@OneToMany(mappedBy="typeroom", cascade = CascadeType.ALL)
	private List<RoomEntity> rooms;
	
}
