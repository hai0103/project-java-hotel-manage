package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.BookRoomEntity;

@Repository
public interface BookRoomRepository extends JpaRepository <BookRoomEntity, Integer> {
	@Query(value = "select * from tbl_bookroom r "
			+ "joint tbl_customer c on r.col_customer_id = c.col_id "
			+ " where"
			+ " (:bookNo is null or r.col_book_no like %:bookNo%)"
			+ " and (:customerName is null or c.col_name like %:customerName%)"
			+ " and (:identity is null or c.col_identity_card = :identity)"
			+ " and (:startDate is null or r.col_start_date >=:startDate)"
			+ " and (:endDate is null or r.col_start_date <=:endDate)"
			+ " and (:customerCode is null or c.col_no like %:customerCode%)"
	, nativeQuery = true)
	
	Page<BookRoomEntity> search(@Param("bookNo") String bookNo,
							 @Param("customerName") String customerName,
							 @Param("identity") String identity,
							 @Param("startDate") Date startDate,
							 @Param("endDate") Date endDate,
							 @Param("customerCode") String customerCode
							 , Pageable pageable);
}
