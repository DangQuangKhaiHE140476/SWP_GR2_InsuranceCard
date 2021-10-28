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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public InsuranceType() {
		super();
	}

	public InsuranceType(Long id, String insurancetype, List<Package> packages,
			List<InsuranceLiability> insuranceLiabilities) {
		super();
		this.id = id;
		this.insurancetype = insurancetype;
		this.packages = packages;
		this.insuranceLiabilities = insuranceLiabilities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInsurancetype() {
		return insurancetype;
	}

	public void setInsurancetype(String insurancetype) {
		this.insurancetype = insurancetype;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<InsuranceLiability> getInsuranceLiabilities() {
		return insuranceLiabilities;
	}

	public void setInsuranceLiabilities(List<InsuranceLiability> insuranceLiabilities) {
		this.insuranceLiabilities = insuranceLiabilities;
	}
	
}
