package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity, Integer> {
	@Query(value = "select * from tbl_customer c "
			+ " where "
			+ " (:customerName is null or c.col_name like %:customerName%)"
			+ " and (:customerNo is null or c.col_no like %:customerNo%)"
			+ " and (:nation is null or c.col_nationality like %:nation%)"
			+ " and (:identityCard is null or c.col_identity_card = :identityCard)"
			+ " and (:dob is null or c.col_dob =:dob)"
			+ " and (:phone is null or c.col_phone like %:phone%)"
			+ " and (:email is null or c.col_email like %:email%)"
	, nativeQuery = true)
	Page<CustomerEntity> search(@Param("customerName") String customerName,
							 @Param("customerNo") String customerNo,
							 @Param("nation") String nation,
							 @Param("identityCard") String identityCard,
							 @Param("dob") Date dob,
							 @Param("phone") String phone,
							 @Param("email") String email
							 , Pageable pageable);
}
