package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Compensation;

public interface CompensationRepo extends CrudRepository<Compensation, Long> {

}
