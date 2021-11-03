package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Request;

public interface RequestRepo extends CrudRepository<Request, Long> {

}
