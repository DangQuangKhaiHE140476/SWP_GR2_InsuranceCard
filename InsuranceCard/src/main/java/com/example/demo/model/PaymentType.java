package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PaymentType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "type", unique = true, length = 25, nullable = false)
	private String type;

	// not a column in table
	@OneToMany(mappedBy = "paymentType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Payment> payments;
}
