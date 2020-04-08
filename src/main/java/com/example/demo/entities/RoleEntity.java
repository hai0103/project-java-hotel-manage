package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.config.Views;
import com.example.demo.utils.ColumnDefinitionConstant;
import com.fasterxml.jackson.annotation.JsonView;
import com.example.demo.entities.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_role")
public class RoleEntity implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_role_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.INTEGER)
	@JsonView(Views.Public.class)
	private int id;
	
	@JsonView(Views.Public.class)
	@Column(name = "col_role_name",nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.NVARCHAR)
	private String roleName;
	
	@OneToMany( mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<UserEntity> users;

}
