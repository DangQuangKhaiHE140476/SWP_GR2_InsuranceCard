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
public class CompensationStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "value", unique = true, length = 10, nullable = false)
	private String value;
	
	// not a column in table
	@OneToMany(mappedBy = "compensationStatus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Compensation> compensations;
}
