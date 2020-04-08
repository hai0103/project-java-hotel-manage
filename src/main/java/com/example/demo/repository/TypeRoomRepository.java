package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TypeRoomEntity;

@Repository
public interface TypeRoomRepository extends JpaRepository <TypeRoomEntity, Integer> {		
	@Query(value = "select * from tbl_typeroom r "
			+ " where"
			+ " (:name is null or r.col_name like %:name%)"
			+ " and (:description is null or r.col_description like %:description%)"
//			+ " and (:price is null or r.col_price = :price)"
	, nativeQuery = true)
	
	Page<TypeRoomEntity> search(@Param("name") String name,
							 	@Param("description") String description
							 , 	Pageable pageable);
}
