package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.InsuranceLiability;

public interface InsuranceLiabilityRepo extends CrudRepository<InsuranceLiability, Long> {
	@Modifying
	@Transactional
	@Query( value = "SELECT `insurance_liability`.`id`,\r\n"
			+ "    `insurance_liability`.`compensationamount`,\r\n"
			+ "    `insurance_liability`.`leveldamage`\r\n"
			+ "FROM `insurancecardsystem1`.`insurance_liability` \r\n"
			+ "WHERE id=?1", nativeQuery = true)
	public ArrayList<InsuranceLiability> getLiability(String id);

	@Modifying
	@Transactional
	@Query( value = "UPDATE `insurancecardsystem1`.`insurance_liability`\r\n"
			+ " SET\r\n"
			+ " `compensationamount` = ?3,\r\n"
			+ " `leveldamage` = ?2\r\n"
			+ " WHERE `id` = ?1", nativeQuery = true)
	public void updateLiability(String id, String leveldamage, String compensationamount);
	
	@Modifying
	@Transactional
	@Query( value = "DELETE FROM `insurancecardsystem1`.`insurance_liability`\r\n"
			+ "WHERE id = ?1", nativeQuery = true)
	public void deleteLiability(String id);
}
