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

	public Request() {
		super();
	}

	public Request(Long id, Timestamp requestdate, User user, Contract contract, RequestType requestType,
			RequestStatus requestStatus) {
		super();
		this.id = id;
		this.requestdate = requestdate;
		this.user = user;
		this.contract = contract;
		this.requestType = requestType;
		this.requestStatus = requestStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Timestamp requestdate) {
		this.requestdate = requestdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}
	
}
