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

	public CompensationStatus() {
		super();
	}

	public CompensationStatus(Long id, String value, List<Compensation> compensations) {
		super();
		this.id = id;
		this.value = value;
		this.compensations = compensations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Compensation> getCompensations() {
		return compensations;
	}

	public void setCompensations(List<Compensation> compensations) {
		this.compensations = compensations;
	}
	
}
