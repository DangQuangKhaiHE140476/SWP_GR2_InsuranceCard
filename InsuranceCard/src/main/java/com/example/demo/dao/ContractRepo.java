package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contract;

@Repository
public interface ContractRepo extends JpaRepository<Contract, Long> {

}
