package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Long> {

}
