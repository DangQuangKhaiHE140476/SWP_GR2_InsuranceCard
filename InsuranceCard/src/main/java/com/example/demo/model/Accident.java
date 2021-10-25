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

	public Accident() {
		super();
	}

	public Accident(Long id, Contract contract, Date accidentDate, String damage, String idaccidentfrompolice,
			String iddamagefromhospital, AccidentStatus accidentStatus, Compensation compensation) {
		super();
		this.id = id;
		this.contract = contract;
		this.accidentDate = accidentDate;
		this.damage = damage;
		this.idaccidentfrompolice = idaccidentfrompolice;
		this.iddamagefromhospital = iddamagefromhospital;
		this.accidentStatus = accidentStatus;
		this.compensation = compensation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getIdaccidentfrompolice() {
		return idaccidentfrompolice;
	}

	public void setIdaccidentfrompolice(String idaccidentfrompolice) {
		this.idaccidentfrompolice = idaccidentfrompolice;
	}

	public String getIddamagefromhospital() {
		return iddamagefromhospital;
	}

	public void setIddamagefromhospital(String iddamagefromhospital) {
		this.iddamagefromhospital = iddamagefromhospital;
	}

	public AccidentStatus getAccidentStatus() {
		return accidentStatus;
	}

	public void setAccidentStatus(AccidentStatus accidentStatus) {
		this.accidentStatus = accidentStatus;
	}

	public Compensation getCompensation() {
		return compensation;
	}

	public void setCompensation(Compensation compensation) {
		this.compensation = compensation;
	}
	
	
}
