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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
}
