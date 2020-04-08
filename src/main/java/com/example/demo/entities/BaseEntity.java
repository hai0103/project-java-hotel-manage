package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.utils.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id", nullable = false, unique = true, columnDefinition = ColumnDefinitionConstant.LONG)
    private long id;

	@DateTimeFormat(pattern = DateUtils.DATE_TIME_FORMAT)
	@Column(name = "col_created_date", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date createdDate;
	
	@DateTimeFormat(pattern = DateUtils.DATE_TIME_FORMAT)
	@Column(name = "col_updated_date", columnDefinition = ColumnDefinitionConstant.DATE)
	private Date updatedDate;
	
	@PrePersist
	private void prePersist() {
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.updatedDate = new Date();
	}
	
	@PreRemove
	public void preRemove() {
		// Nothing to do
	}
	
	@PreDestroy
	public void preDestroy() {
		// Nothing to do
	}
}
