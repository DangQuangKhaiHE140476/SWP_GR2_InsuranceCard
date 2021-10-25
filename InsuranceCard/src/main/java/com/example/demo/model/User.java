package com.example.demo.model;

import java.sql.Date;
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

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "socialsercuritynumber", unique = true, length = 12, nullable = false)
	private String socialsercuritynumber;
	
	@Column(name = "dob", nullable = false)
	private Date dob;
	
	@Column(name = "gender", nullable = false)
	private boolean gender;
	
	@Column(name = "address", length = 100, nullable = false)
	private String address;
	
	@Column(name = "phonenumber", unique = true, length = 10, nullable = false)
	private String phonenumber;
	
	@Column(name = "email", unique = true, length = 50, nullable = false)
	private String email;
	
	@Column(name = "username", unique = true, length = 30, nullable = false)
	private String username;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "roleid", nullable = false)
	private Role role;
	
	//not a column in table
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contract> contracts;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Request> requests;
}