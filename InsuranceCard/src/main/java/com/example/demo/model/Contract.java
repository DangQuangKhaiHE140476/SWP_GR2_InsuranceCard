package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "creationdate", nullable = false)
	private Timestamp creationdate;
	
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "vehicleid",unique = true, nullable = false)
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "packageid", nullable = false)
	private Package package_;
	
	@ManyToOne
	@JoinColumn(name = "statusid", nullable = false)
	private ContractStatus contractStatus;
	
	//not a column in table
	@OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Accident> accidents;
	
	@OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Request> requests;
	
	@OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Punishment> punishments;
	
	@OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Payment> payments;

	public Contract() {
		super();
	}

	public Contract(Long id, Timestamp creationdate, User user, Vehicle vehicle, Package package_,
			ContractStatus contractStatus, List<Accident> accidents, List<Request> requests,
			List<Punishment> punishments, List<Payment> payments) {
		super();
		this.id = id;
		this.creationdate = creationdate;
		this.user = user;
		this.vehicle = vehicle;
		this.package_ = package_;
		this.contractStatus = contractStatus;
		this.accidents = accidents;
		this.requests = requests;
		this.punishments = punishments;
		this.payments = payments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Timestamp creationdate) {
		this.creationdate = creationdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Package getPackage_() {
		return package_;
	}

	public void setPackage_(Package package_) {
		this.package_ = package_;
	}

	public ContractStatus getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
	}

	public List<Accident> getAccidents() {
		return accidents;
	}

	public void setAccidents(List<Accident> accidents) {
		this.accidents = accidents;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Punishment> getPunishments() {
		return punishments;
	}

	public void setPunishments(List<Punishment> punishments) {
		this.punishments = punishments;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
}
