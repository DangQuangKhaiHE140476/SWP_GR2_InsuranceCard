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
}
