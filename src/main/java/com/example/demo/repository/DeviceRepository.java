package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.example.demo.entities.DeviceEntity;

@Repository
public interface DeviceRepository extends JpaRepository <DeviceEntity, Integer> {		
//	@Query(value = "select * from tbl_room r "
//			+ " where"
//			+ " (:roomNo is null or r.col_no like %:roomNo%)"
//			+ " and (:statusStay is null or r.col_status_stay like %:statusStay%)"
//			+ " and (:roomTypeId is null or r.col_typeroom_id = :roomTypeId)"
//			+ " and (:status is null or r.col_status like %:status%)"
//			+ " and (:nop is null or r.col_nop like %:nop%)"
//	, nativeQuery = true)
//	
//	Page<RoomEntity> search(@Param("roomNo") String roomNo,
//							 @Param("roomTypeId") Integer roomTypeId,
//							 @Param("status") String status,
//							 @Param("statusStay") String statusStay,
//							 @Param("nop") Integer nop
//							 , Pageable pageable);

}
