package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VehicleType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "vehicletype", unique = true, length = 25, nullable = false)
	private String vehicletype;
	
	//not a column in table
	@OneToMany(mappedBy = "vehicleType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vehicle> vehicles;
	
	@OneToMany(mappedBy = "vehicleType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Package> packages;

	public VehicleType() {
		super();
	}

	public VehicleType(Long id, String vehicletype, List<Vehicle> vehicles, List<Package> packages) {
		super();
		this.id = id;
		this.vehicletype = vehicletype;
		this.vehicles = vehicles;
		this.packages = packages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	
}
