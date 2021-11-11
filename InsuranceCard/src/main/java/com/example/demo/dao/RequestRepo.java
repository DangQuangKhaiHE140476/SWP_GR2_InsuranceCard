package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Request;

public interface RequestRepo extends CrudRepository<Request, Long> {
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `request`.`id`,\r\n"
			+ "    `request`.`requestdate`,\r\n"
			+ "    `request`.`contractid`,\r\n"
			+ "    `request`.`statusid`,\r\n"
			+ "    `request`.`typeid`,\r\n"
			+ "    `request`.`userid`\r\n"
			+ "FROM `insurancecardsystem1`.`request`\r\n"
			+ "Where typeid=?1", nativeQuery = true)
	public ArrayList<Request> getRequestByTypeID(String id);

	
	@Modifying
	@Transactional
	@Query( value = "UPDATE `insurancecardsystem1`.`request`\r\n"
			+ "SET\r\n"
			+ "`statusid` = 2\r\n"
			+ "WHERE `typeid` = 5 AND `contractid` = ?1",nativeQuery = true)
	public void resolveCompensationRequest(String id);
}
