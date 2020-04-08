package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.config.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post")
public class PostEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@JsonView(Views.Public.class)
	@Column(name = "title", columnDefinition = "NVARCHAR(255)")
	private String title;
	
	@JsonView(Views.Public.class)
	@Column(name = "description", columnDefinition = "NVARCHAR(255)")
	private String description;

}
