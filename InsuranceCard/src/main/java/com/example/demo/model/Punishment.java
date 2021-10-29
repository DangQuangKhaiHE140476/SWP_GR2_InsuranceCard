package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Punishment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "amount", nullable = false)
	private int amount;

	@Column(name = "reason", nullable = false)
	private String reason;

	@Column(name = "deadline", nullable = false)
	private Timestamp deadline;

	@ManyToOne
	@JoinColumn(name = "contractid", nullable = false)
	private Contract contract;

	@ManyToOne
	@JoinColumn(name = "status", nullable = false)
	private PunishmentStatus punishmentStatus;

	// not a column in table
	@OneToOne(mappedBy = "punishment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Payment payment;

	public Punishment() {
		super();
	}

	public Punishment(Long id, int amount, String reason, Timestamp deadline, Contract contract,
			PunishmentStatus punishmentStatus, Payment payment) {
		super();
		this.id = id;
		this.amount = amount;
		this.reason = reason;
		this.deadline = deadline;
		this.contract = contract;
		this.punishmentStatus = punishmentStatus;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public PunishmentStatus getPunishmentStatus() {
		return punishmentStatus;
	}

	public void setPunishmentStatus(PunishmentStatus punishmentStatus) {
		this.punishmentStatus = punishmentStatus;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
