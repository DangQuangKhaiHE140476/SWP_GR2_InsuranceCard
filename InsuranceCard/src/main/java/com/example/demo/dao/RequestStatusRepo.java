package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.RequestStatus;

public interface RequestStatusRepo extends CrudRepository<RequestStatus, Long> {

	@Modifying
	@Transactional
	@Query( value = "SELECT `request_status`.`id`,\r\n"
			+ "    `request_status`.`status`\r\n"
			+ "FROM `insurancecardsystem1`.`request_status`\r\n"
			+ "where status = ?1", nativeQuery = true)
	public ArrayList<RequestStatus> getRequestStatus(String status);
}
