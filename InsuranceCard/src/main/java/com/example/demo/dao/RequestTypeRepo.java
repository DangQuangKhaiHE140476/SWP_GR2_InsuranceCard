package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.RequestType;
import com.example.demo.model.User;

public interface RequestTypeRepo extends CrudRepository<RequestType, Long> {
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `request_type`.`id`,\r\n"
			+ "    `request_type`.`type`\r\n"
			+ "FROM `insurancecardsystem1`.`request_type`\r\n"
			+ "where type=?1", nativeQuery = true)
	public ArrayList<RequestType> getRequestType(String type);
}
