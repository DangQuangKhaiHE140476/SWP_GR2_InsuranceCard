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
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ownername", unique = true, length = 50, nullable = false)
	private String ownername;

	@ManyToOne
	@JoinColumn(name = "typeid", nullable = false)
	private VehicleType vehicleType;
	
	@Column(name = "brand", length = 50, nullable = false)
	private String brand;
	
	@Column(name = "model", length = 50, nullable = false)
	private String model;
	
	@Column(name = "color", length = 20, nullable = false)
	private String color;
	
	@Column(name = "registrationdate", nullable = false)
	private Date registrationdate;
	
	@Column(name = "chassisnumber", unique = true, length = 12, nullable = false)
	private String chassisnumber;
	
	@Column(name = "licenseplates", unique = true, length = 10, nullable = false)
	private String licenseplates;
	
	//not a column in table
	@OneToOne(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Contract contract;
	
}
