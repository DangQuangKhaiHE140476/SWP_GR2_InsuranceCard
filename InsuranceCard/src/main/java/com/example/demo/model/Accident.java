package com.example.demo.model;

import java.sql.Date;

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
public class Accident {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "contractid", nullable = false)
	private Contract contract;
	
	@Column(name = "accidentDate", nullable = false)
	private Date accidentDate;
	
	@Column(name = "damage", nullable = false)
	private String damage;
	
	@Column(name = "idaccidentfrompolice", length = 25, nullable = false)
	private String idaccidentfrompolice;
	
	@Column(name = "iddamagefromhospital", length = 25, nullable = false)
	private String iddamagefromhospital;

	@ManyToOne
	@JoinColumn(name = "statusid", nullable = false)
	private AccidentStatus accidentStatus;
	
	//not a column in table
	@OneToOne(mappedBy = "accident", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Compensation compensation;
}
