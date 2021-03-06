package com.example.demo.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Punishment;

public interface PunishmentRepo extends CrudRepository<Punishment, Long> {

	@Modifying
	@Transactional
	@Query( value = "SELECT `punishment`.`id`,\r\n"
			+ "    `punishment`.`amount`,\r\n"
			+ "    `punishment`.`deadline`,\r\n"
			+ "    `punishment`.`reason`,\r\n"
			+ "    `punishment`.`contractid`,\r\n"
			+ "    `punishment`.`status`\r\n"
			+ "FROM `insurancecardsystem1`.`punishment`\r\n"
			+ "where contractid = ?1", nativeQuery = true)
	public ArrayList<Punishment> getPunishmentByContractID(String id);
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `punishment`.`id`,\r\n"
			+ "    `punishment`.`amount`,\r\n"
			+ "    `punishment`.`deadline`,\r\n"
			+ "    `punishment`.`reason`,\r\n"
			+ "    `punishment`.`contractid`,\r\n"
			+ "    `punishment`.`status`\r\n"
			+ "FROM `insurancecardsystem1`.`punishment`\r\n"
			+ "where id = ?1", nativeQuery = true)
	public ArrayList<Punishment> getPunishmentByID(String id);
	
	@Modifying
	@Transactional
	@Query( value = "UPDATE `insurancecardsystem1`.`punishment`\r\n"
			+ "SET\r\n"
			+ "`amount`=?1,\r\n"
			+ "`deadline`=?2,\r\n"
			+ "`reason`=?3\r\n"
			+ "WHERE id=?4", nativeQuery = true)
	public void editPunishment(String amount, String deadline, String reason, String id);
}
