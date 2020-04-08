package com.example.demo.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.config.Views;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import com.example.demo.utils.ColumnDefinitionConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_room")
@JsonIgnoreProperties(value = { "bookRooms" })
public class RoomEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_room_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
//	@JsonView(Views.Public.class)
	private int id;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_name", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String name;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_no", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String no;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_nop", columnDefinition = ColumnDefinitionConstant.INTEGER)
	private Integer nop;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_price", columnDefinition = ColumnDefinitionConstant.FLOAT)
	private Float price;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_status", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String status;
	
	@Column(name = "col_status_stay", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String statusStay;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_numpeople", columnDefinition = "INT")
	private Integer numpeople;
	
//	@JsonView(Views.Public.class)
	@ManyToOne
	@JoinColumn(name = "col_typeroom_id", foreignKey = @ForeignKey(name = "FK_ROOM_CAT"))
	private TypeRoomEntity typeroom;

    @ManyToMany(mappedBy = "rooms")
    private List<BookRoomEntity> bookRooms;
    
    @ManyToMany(mappedBy = "rooms")
    private List<DeviceEntity> devices;
}
