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
public class RequestStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "status", unique = true, length = 20, nullable = false)
	private String status;
	
	//not a column in table
	@OneToMany(mappedBy = "requestStatus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Request> requests;
}
