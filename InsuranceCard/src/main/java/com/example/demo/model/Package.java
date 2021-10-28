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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "vehicletype", nullable = false)
	private VehicleType vehicleType;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(name = "duration", length = 10, nullable = false)
	private String duration;

	@ManyToOne
	@JoinColumn(name = "insurancetype", nullable = false)
	private InsuranceType insuranceType;

	// not a column in table
	@OneToMany(mappedBy = "package_", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contract> contracts;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Package_InsuranceLiability", joinColumns = {
			@JoinColumn(name = "packageid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "insuranceliabilityid", referencedColumnName = "id") })
	private List<InsuranceLiability> insuranceLiabilities;

	public Package() {
		super();
	}

	public Package(Long id, VehicleType vehicleType, int price, String duration, InsuranceType insuranceType,
			List<Contract> contracts, List<InsuranceLiability> insuranceLiabilities) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
		this.price = price;
		this.duration = duration;
		this.insuranceType = insuranceType;
		this.contracts = contracts;
		this.insuranceLiabilities = insuranceLiabilities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public List<InsuranceLiability> getInsuranceLiabilities() {
		return insuranceLiabilities;
	}

	public void setInsuranceLiabilities(List<InsuranceLiability> insuranceLiabilities) {
		this.insuranceLiabilities = insuranceLiabilities;
	}
	
}
