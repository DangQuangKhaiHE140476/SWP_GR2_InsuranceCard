package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.CompensationStatus;

public interface CompensationStatusRepo extends JpaRepository<CompensationStatus, Long>{
	@Modifying
	@Transactional
	@Query( value = "SELECT `compensation_status`.`id`,\r\n"
			+ "    `compensation_status`.`value`\r\n"
			+ "FROM `insurancecardsystem1`.`compensation_status`\r\n"
			+ "WHERE ID =2", nativeQuery = true)
	public ArrayList<CompensationStatus> getUNPAIDCompensationStatus();
}
