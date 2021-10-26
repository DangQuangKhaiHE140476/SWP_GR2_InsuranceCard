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
public class RequestType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "type", unique = true, length = 20, nullable = false)
	private String type;
	
	//not a column in table
	@OneToMany(mappedBy = "requestType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Request> requests;

	public RequestType() {
		super();
	}

	public RequestType(Long id, String type, List<Request> requests) {
		super();
		this.id = id;
		this.type = type;
		this.requests = requests;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
}
