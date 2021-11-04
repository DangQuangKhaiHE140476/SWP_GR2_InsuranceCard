package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.PaymentType;
import com.example.demo.model.PunishmentStatus;

public interface PunishmentStatusRepo extends CrudRepository<PunishmentStatus, Long> {
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `punishment_status`.`id`,\r\n"
			+ "    `punishment_status`.`status`\r\n"
			+ "FROM `insurancecardsystem1`.`punishment_status`\r\n"
			+ "Where status=?1", nativeQuery = true)
	public ArrayList<PunishmentStatus> getPunishMentTypePaid(String type);
}
