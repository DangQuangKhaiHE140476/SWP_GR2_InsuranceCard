package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "requestdate", nullable = false)
	private Timestamp requestdate;
	
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "contractid", nullable = false)
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name = "typeid", nullable = false)
	private RequestType requestType;
	
	@ManyToOne
	@JoinColumn(name = "statusid", nullable = false)
	private RequestStatus requestStatus;
}
