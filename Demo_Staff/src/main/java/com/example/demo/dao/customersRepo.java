package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.customers;

public interface customersRepo extends CrudRepository<customers, Long> {
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `customers`.`id`,\r\n"
			+ "    `customers`.`name`,\r\n"
			+ "    `customers`.`socialsecuritynumber`,\r\n"
			+ "    `customers`.`dob`,\r\n"
			+ "    `customers`.`gender`,\r\n"
			+ "    `customers`.`address`,\r\n"
			+ "    `customers`.`phonenumber`,\r\n"
			+ "    `customers`.`email`,\r\n"
			+ "    `customers`.`username`,\r\n"
			+ "    `customers`.`password`,\r\n"
			+ "    `customers`.`roleid`\r\n"
			+ "FROM `test`.`customers`\r\n"
			+ "WHERE roleid = 3", nativeQuery = true)
	public ArrayList<customers> getAllStaff();
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `customers`.`id`,\r\n"
			+ "    `customers`.`name`,\r\n"
			+ "    `customers`.`socialsecuritynumber`,\r\n"
			+ "    `customers`.`dob`,\r\n"
			+ "    `customers`.`gender`,\r\n"
			+ "    `customers`.`address`,\r\n"
			+ "    `customers`.`phonenumber`,\r\n"
			+ "    `customers`.`email`,\r\n"
			+ "    `customers`.`username`,\r\n"
			+ "    `customers`.`password`,\r\n"
			+ "    `customers`.`roleid`\r\n"
			+ "FROM `test`.`customers`\r\n"
			+ "WHERE roleid = 3 AND id = ?1", nativeQuery = true)
	public ArrayList<customers> getStaff(String id);
	
	@Modifying
	@Transactional
	@Query( value = "DELETE FROM `test`.`customers`\r\n"
			+ "WHERE roleid = 3 and id = ?1", nativeQuery = true)
	public void deleteStaff(String id);
}
