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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}
