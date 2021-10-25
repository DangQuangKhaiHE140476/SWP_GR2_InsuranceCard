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

	public Payment() {
		super();
	}

	public Payment(Long id, Timestamp paymentdate, Contract contract, Punishment punishment, PaymentType paymentType) {
		super();
		this.id = id;
		this.paymentdate = paymentdate;
		this.contract = contract;
		this.punishment = punishment;
		this.paymentType = paymentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Timestamp paymentdate) {
		this.paymentdate = paymentdate;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Punishment getPunishment() {
		return punishment;
	}

	public void setPunishment(Punishment punishment) {
		this.punishment = punishment;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
}
