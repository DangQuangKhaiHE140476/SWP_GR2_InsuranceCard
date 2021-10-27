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
public class AccidentStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "status", unique = true, length = 20, nullable = false)
	private String status;
	
	//not a column in table
	@OneToMany(mappedBy = "accidentStatus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Accident> accidents;

	public AccidentStatus() {
		super();
	}

	public AccidentStatus(Long id, String status, List<Accident> accidents) {
		super();
		this.id = id;
		this.status = status;
		this.accidents = accidents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Accident> getAccidents() {
		return accidents;
	}

	public void setAccidents(List<Accident> accidents) {
		this.accidents = accidents;
	}
	
}
