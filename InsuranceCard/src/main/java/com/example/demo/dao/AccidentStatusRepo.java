package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AccidentStatus;

public interface AccidentStatusRepo extends JpaRepository<AccidentStatus, Long>{
	
	List<AccidentStatus> findAll();
}