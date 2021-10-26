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

	public Vehicle() {
		super();
	}

	public Vehicle(Long id, String ownername, VehicleType vehicleType, String brand, String model, String color,
			Date registrationdate, String chassisnumber, String licenseplates, Contract contract) {
		super();
		this.id = id;
		this.ownername = ownername;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registrationdate = registrationdate;
		this.chassisnumber = chassisnumber;
		this.licenseplates = licenseplates;
		this.contract = contract;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public String getChassisnumber() {
		return chassisnumber;
	}

	public void setChassisnumber(String chassisnumber) {
		this.chassisnumber = chassisnumber;
	}

	public String getLicenseplates() {
		return licenseplates;
	}

	public void setLicenseplates(String licenseplates) {
		this.licenseplates = licenseplates;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
}
