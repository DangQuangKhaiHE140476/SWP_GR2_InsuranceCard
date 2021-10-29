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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type", unique = true, length = 25, nullable = false)
	private String type;

	// not a column in table
	@OneToMany(mappedBy = "paymentType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Payment> payments;

	public PaymentType() {
		super();
	}

	public PaymentType(Long id, String type, List<Payment> payments) {
		super();
		this.id = id;
		this.type = type;
		this.payments = payments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
}
