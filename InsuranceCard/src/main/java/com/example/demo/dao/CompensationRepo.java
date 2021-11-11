package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Compensation;

public interface CompensationRepo extends JpaRepository<Compensation, Long> {
	@Modifying
	@Transactional
	@Query( value = "SELECT `compensation`.`id`,\r\n"
			+ "    `compensation`.`accidentid`,\r\n"
			+ "    `compensation`.`statusid`\r\n"
			+ "FROM `insurancecardsystem1`.`compensation`\r\n"
			+ "WHERE `compensation`.`id`=?1" , nativeQuery = true)
	public ArrayList<Compensation> getCompensationByID(String id);

	
	@Modifying
	@Transactional
	@Query( value = "UPDATE `insurancecardsystem1`.`compensation`\r\n"
			+ "SET\r\n"
			+ "`statusid` = 1\r\n"
			+ "WHERE `accidentid` = ?1" , nativeQuery = true)
	public void paidCompensation(String id);
}
