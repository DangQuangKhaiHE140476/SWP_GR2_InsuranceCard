package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;


public interface UserRepo extends CrudRepository<User, Long> {
	@Modifying
	@Transactional
	@Query( value = "SELECT `user`.`id`,\r\n"
			+ "    `user`.`address`,\r\n"
			+ "    `user`.`dob`,\r\n"
			+ "    `user`.`email`,\r\n"
			+ "    `user`.`gender`,\r\n"
			+ "    `user`.`name`,\r\n"
			+ "    `user`.`password`,\r\n"
			+ "    `user`.`phonenumber`,\r\n"
			+ "    `user`.`socialsercuritynumber`,\r\n"
			+ "    `user`.`username`,\r\n"
			+ "    `user`.`roleid`\r\n"
			+ "FROM `insurancecardsystem1`.`user`\r\n"
			+ "Where roleid=2;", nativeQuery = true)
	public ArrayList<User> getAllStaff();
	
	@Modifying
	@Transactional
	@Query( value = "SELECT `user`.`id`,\r\n"
			+ "    `user`.`address`,\r\n"
			+ "    `user`.`dob`,\r\n"
			+ "    `user`.`email`,\r\n"
			+ "    `user`.`gender`,\r\n"
			+ "    `user`.`name`,\r\n"
			+ "    `user`.`password`,\r\n"
			+ "    `user`.`phonenumber`,\r\n"
			+ "    `user`.`socialsercuritynumber`,\r\n"
			+ "    `user`.`username`,\r\n"
			+ "    `user`.`roleid`\r\n"
			+ "FROM `insurancecardsystem1`.`user`\r\n"
			+ "Where roleid=2 AND id = ?1", nativeQuery = true)
	public ArrayList<User> getStaff(String id);
	
	@Modifying
	@Transactional
	@Query( value = "DELETE FROM `insurancecardsystem1`.`user`\r\n"
			+ "WHERE roleid = 2 and id = ?1", nativeQuery = true)
	public void deleteStaff(String id);
}
