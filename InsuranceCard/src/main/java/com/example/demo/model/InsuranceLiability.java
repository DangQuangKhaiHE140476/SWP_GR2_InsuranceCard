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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "address",unique = true, nullable = false)
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
}
