package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Payment;
import com.example.demo.model.RequestType;

public interface PaymentRepo extends CrudRepository<Payment, Long> {
	@Modifying
	@Transactional
	@Query( value = "SELECT `payment`.`id`,\r\n"
			+ "    `payment`.`paymentdate`,\r\n"
			+ "    `payment`.`contractid`,\r\n"
			+ "    `payment`.`typeid`,\r\n"
			+ "    `payment`.`punishmentid`\r\n"
			+ "FROM `insurancecardsystem1`.`payment`\r\n"
			+ "where contractid=?1", nativeQuery = true)
	public ArrayList<Payment> getPaymentByContractID(String id);
}
