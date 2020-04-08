package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Integer> {

}
