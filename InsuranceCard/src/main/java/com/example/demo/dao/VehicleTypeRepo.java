package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.VehicleType;

@Repository
public interface VehicleTypeRepo extends JpaRepository<VehicleType, Long>{

}
