package com.example.demo.dao;

import java.util.ArrayList; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Package;

@Repository
public interface PackageRepo extends JpaRepository<Package, Long>{

	@Modifying
	@Transactional
	@Query(value = "select * from package", nativeQuery = true)
	public ArrayList<Package> getAllPackage();
	
	@Modifying
	@Transactional
	@Query(value = "select * from package where id=?1", nativeQuery = true)
	public ArrayList<Package> getPackageById(String id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE package \r\n"
			+ "SET duration=?2, price=?3, insurancetype=?4, vehicletype=?5 \r\n"
			+ "WHERE id=?1", nativeQuery = true)
	public void updatePackage(String id, String duration, int price, String insurancetype, String vehicletype);
	
	@Modifying
	@Transactional
	@Query(value = "delete from package_insurance_liability where packageid=?1", nativeQuery = true)
	public void deletePackageInsuranceLiability(String id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO package_insurance_liability VALUES (?1,?2)", nativeQuery = true)
	public void insertPackageInsuranceLiability(String packageid, String liabilityid);
}
