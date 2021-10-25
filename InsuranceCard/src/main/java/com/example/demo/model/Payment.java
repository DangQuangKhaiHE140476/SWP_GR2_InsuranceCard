package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "paymentdate", nullable = false)
	private Timestamp paymentdate;
	
	@ManyToOne
	@JoinColumn(name = "contractid", nullable = false)
	private Contract contract;
	
	@OneToOne
	@JoinColumn(name = "punishmentid", nullable = false)
	private Punishment punishment;
	
	@ManyToOne
	@JoinColumn(name = "typeid", nullable = false)
	private PaymentType paymentType;
}
