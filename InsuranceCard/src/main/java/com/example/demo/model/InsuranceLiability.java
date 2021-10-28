package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class InsuranceLiability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "leveldamage",unique = true, nullable = false)
	private String levelDamage;
	
	@Column(name = "compensationamount", nullable = false)
	private int compensationAmount;
	
	//not a column in table
	@ManyToMany(mappedBy = "insuranceLiabilities", fetch = FetchType.LAZY)
	private List<Package> packages;
	
	@ManyToMany(mappedBy = "insuranceLiabilities", fetch = FetchType.LAZY)
	private List<InsuranceType> insuranceTypes;
	
	@ManyToMany(mappedBy = "insuranceLiabilities", fetch = FetchType.LAZY)
	private List<Compensation> compensations;

	public InsuranceLiability() {
		super();
	}

	public InsuranceLiability(Long id, String levelDamage, int compensationAmount, List<Package> packages,
			List<InsuranceType> insuranceTypes, List<Compensation> compensations) {
		super();
		this.id = id;
		this.levelDamage = levelDamage;
		this.compensationAmount = compensationAmount;
		this.packages = packages;
		this.insuranceTypes = insuranceTypes;
		this.compensations = compensations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevelDamage() {
		return levelDamage;
	}

	public void setLevelDamage(String levelDamage) {
		this.levelDamage = levelDamage;
	}

	public int getCompensationAmount() {
		return compensationAmount;
	}

	public void setCompensationAmount(int compensationAmount) {
		this.compensationAmount = compensationAmount;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<InsuranceType> getInsuranceTypes() {
		return insuranceTypes;
	}

	public void setInsuranceTypes(List<InsuranceType> insuranceTypes) {
		this.insuranceTypes = insuranceTypes;
	}

	public List<Compensation> getCompensations() {
		return compensations;
	}

	public void setCompensations(List<Compensation> compensations) {
		this.compensations = compensations;
	}
	
}
