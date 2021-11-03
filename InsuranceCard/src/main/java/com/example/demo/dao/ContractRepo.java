package com.example.demo.dao;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contract;

@Repository
public interface ContractRepo extends CrudRepository<Contract, Long> {
	@Modifying
	@Transactional
	@Query( value = "SELECT `contract`.`id`,\r\n"
			+ "    `contract`.`creationdate`,\r\n"
			+ "    `contract`.`statusid`,\r\n"
			+ "    `contract`.`packageid`,\r\n"
			+ "    `contract`.`userid`,\r\n"
			+ "    `contract`.`vehicleid`\r\n"
			+ "FROM `insurancecardsystem1`.`contract`\r\n"
			+ "where userid = ?1", nativeQuery = true)
	public ArrayList<Contract> getContractByUserID(String id);
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `contract`.`id`,\r\n"
			+ "    `contract`.`creationdate`,\r\n"
			+ "    `contract`.`statusid`,\r\n"
			+ "    `contract`.`packageid`,\r\n"
			+ "    `contract`.`userid`,\r\n"
			+ "    `contract`.`vehicleid`\r\n"
			+ "FROM `insurancecardsystem1`.`contract`\r\n"
			+ "where id = ?1", nativeQuery = true)
	public ArrayList<Contract> getContractByID(String id);
}
