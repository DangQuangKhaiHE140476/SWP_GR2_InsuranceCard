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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}
