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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public User() {
		super();
	}

	public User(Long id, String name, String socialsercuritynumber, Date dob, boolean gender, String address,
			String phonenumber, String email, String username, String password, Role role, List<Contract> contracts,
			List<Request> requests) {
		super();
		this.id = id;
		this.name = name;
		this.socialsercuritynumber = socialsercuritynumber;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.contracts = contracts;
		this.requests = requests;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialsercuritynumber() {
		return socialsercuritynumber;
	}

	public void setSocialsercuritynumber(String socialsercuritynumber) {
		this.socialsercuritynumber = socialsercuritynumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
}