package com.example.demo.dao;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;


public interface UserRepo extends JpaRepository<User, Long> {
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
			+ "where roleid = 1 AND id = ?1", nativeQuery = true)
	public ArrayList<User> getUser(String id);
	
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
			+ "Where roleid=3 AND id = ?1", nativeQuery = true)
	public ArrayList<User> getCustomer(String id);
	
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
			+ "Where roleid=3", nativeQuery = true)
	public ArrayList<User> getAllCustomer();
	
	User findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE `insurancecardsystem1`.`user`\r\n"
			+ "SET\r\n"
			+ "`name` = ?1,\r\n"
			+ "`socialsercuritynumber` = ?2,\r\n"
			+ "`dob` = ?3,\r\n"
			+ "`gender` = ?4,\r\n"
			+ "`address` = ?5,\r\n"
			+ "`phonenumber` = ?6,\r\n"
			+ "`email` = ?7\r\n"
			+ "WHERE `id` = ?8", nativeQuery = true)
	public void updateUserProfile(
			String name, 
			String ssn, 
			Date dob, 
			boolean gender, 
			String address, 
			String phonenumber, 
			String email,
			String id);
}
