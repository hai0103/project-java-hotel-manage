package com.example.demo.entities;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "tbl_user")
@JsonIgnoreProperties(value = { "role" })
public class UserEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_user_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
//	@JsonView(Views.Public.class)
	private int id;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_username",nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String username;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_email",nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String email;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_password", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String password;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_created_at", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date created_at;
	
//	@JsonView(Views.Public.class)
	@Column(name = "col_phone", columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String phone;
	
//	@JsonView(Views.Public.class)
	@ManyToOne
	@JoinColumn(name = "col_role_id", foreignKey = @ForeignKey(name = "FK_USER_ROLE"))
	private RoleEntity role;
	
}
