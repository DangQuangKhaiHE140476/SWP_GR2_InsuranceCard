package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class InsuranceType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "insurancetype", unique = true, length = 25, nullable = false)
	private String insurancetype;

	// not a column in table
	@OneToMany(mappedBy = "insuranceType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Package> packages;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "InsuranceType_Liability", joinColumns = {
			@JoinColumn(name = "insurancetypeid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "insuranceliabilityid", referencedColumnName = "id") })
	private List<InsuranceLiability> insuranceLiabilities;
}
