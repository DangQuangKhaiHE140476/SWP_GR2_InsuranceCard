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
public class PunishmentStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "status", unique = true, length = 20, nullable = false)
	private String status;

	// not a column in table
	@OneToMany(mappedBy = "punishmentStatus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Punishment> punishments;

	public PunishmentStatus() {
		super();
	}

	public PunishmentStatus(Long id, String status, List<Punishment> punishments) {
		super();
		this.id = id;
		this.status = status;
		this.punishments = punishments;
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

	public List<Punishment> getPunishments() {
		return punishments;
	}

	public void setPunishments(List<Punishment> punishments) {
		this.punishments = punishments;
	}
	
}
