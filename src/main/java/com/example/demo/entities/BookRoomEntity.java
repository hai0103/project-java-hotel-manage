package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name="tbl_bookroom")

public class BookRoomEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_book_room_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
	@JsonView(Views.Public.class)
	private int id;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_bookNo", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String bookNo;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_start_date", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date start_date;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_end_date", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date end_date;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_created_date", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date created_date;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_status", columnDefinition = ColumnDefinitionConstant.INTEGER)
	private Integer status;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_deposit", columnDefinition = ColumnDefinitionConstant.FLOAT)
	private Float deposit;
	
	@JsonView(Views.Public.class)
	@ManyToOne
	@JoinColumn(name = "col_customer_id", foreignKey = @ForeignKey(name = "FK_BROOM_CUS"))
	private CustomerEntity customer;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "bookroom_room",
            joinColumns = @JoinColumn(name = "col_bookroom_id"), 
            inverseJoinColumns = @JoinColumn(name = "col_room_id") 
    )
    private List<RoomEntity> rooms;


}
