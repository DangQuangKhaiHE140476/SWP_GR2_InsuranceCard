package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.PaymentType;

public interface PaymentTypeRepo extends CrudRepository<PaymentType, Long> {
	@Modifying
	@Transactional
	@Query( value = "SELECT `payment_type`.`id`,\r\n"
			+ "    `payment_type`.`type`\r\n"
			+ "FROM `insurancecardsystem1`.`payment_type`\r\n"
			+ "where type = ?1", nativeQuery = true)
	public ArrayList<PaymentType> getPaymentType(String type);
}
