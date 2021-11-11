package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Accident;

public interface AccidentRepo extends CrudRepository<Accident, Long> {
	@Modifying
	@Transactional
	@Query( value = "SELECT `accident`.`id`,\r\n"
			+ "    `accident`.`accident_date`,\r\n"
			+ "    `accident`.`damage`,\r\n"
			+ "    `accident`.`idaccidentfrompolice`,\r\n"
			+ "    `accident`.`iddamagefromhospital`,\r\n"
			+ "    `accident`.`statusid`,\r\n"
			+ "    `accident`.`contractid`\r\n"
			+ "FROM `insurancecardsystem1`.`accident`\r\n"
			+ "Where contractid = ?1", nativeQuery = true)
	public ArrayList<Accident> getAccidentByContractID(String id);
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `accident`.`id`,\r\n"
			+ "    `accident`.`accident_date`,\r\n"
			+ "    `accident`.`damage`,\r\n"
			+ "    `accident`.`idaccidentfrompolice`,\r\n"
			+ "    `accident`.`iddamagefromhospital`,\r\n"
			+ "    `accident`.`statusid`,\r\n"
			+ "    `accident`.`contractid`\r\n"
			+ "FROM `insurancecardsystem1`.`accident`\r\n"
			+ "Where id = ?1", nativeQuery = true)
	public ArrayList<Accident> getAccidentByID(String id);
	
	@Modifying
	@Transactional
	@Query( value = "UPDATE `insurancecardsystem1`.`accident`\r\n"
			+ "SET\r\n"
			+ "`statusid` = 1\r\n"
			+ "WHERE `id` = ?1", nativeQuery = true)
	public void approve (String id);
	
	@Modifying
	@Transactional
	@Query( value = "UPDATE `insurancecardsystem1`.`accident`\r\n"
			+ "SET\r\n"
			+ "`statusid` = 2\r\n"
			+ "WHERE `id` = ?1", nativeQuery = true)
	public void reject (String id);
}
