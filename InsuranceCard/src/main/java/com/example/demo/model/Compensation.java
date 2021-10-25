package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Compensation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "accidentid", nullable = false)
	private Accident accident;
	
	@ManyToOne
	@JoinColumn(name = "statusid", nullable = false)
	private CompensationStatus compensationStatus;
	
	//not a column in table
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Compensation_ChossenLiability", joinColumns = {
			@JoinColumn(name = "compensationid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "liabilityid", referencedColumnName = "id") })
	private List<InsuranceLiability> insuranceLiabilities;
}
