package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.config.Views;
import com.example.demo.utils.ColumnDefinitionConstant;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_device")
public class DeviceEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_device_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
	@JsonView(Views.Public.class)
	private int id;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_name", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String name;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_no", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String no;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "device_room",
            joinColumns = @JoinColumn(name = "col_device_id"), 
            inverseJoinColumns = @JoinColumn(name = "col_room_id") 
    )
    private List<RoomEntity> rooms;
	
}
