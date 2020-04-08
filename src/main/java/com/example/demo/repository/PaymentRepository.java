package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PaymentEntity;

public interface PaymentRepository extends JpaRepository <PaymentEntity, Integer>{

}
