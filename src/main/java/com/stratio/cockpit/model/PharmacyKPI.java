package com.stratio.cockpit.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "pharmacy_kpi")
@EntityListeners(AuditingEntityListener.class)
public class PharmacyKPI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @JsonIgnore
    @OneToOne
	private Pharmacy pharmacy;

	@NotBlank
	private int sez;
	@NotBlank
	private int fytdNos;
	@NotBlank
	private int fyatdNos;
	
	@NotBlank
	private int lxVsNosFytd;
	
	@NotBlank
	private int fyaNos;
	
	@NotBlank
	private long growthPotential;
     


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public int getSez() {
		return sez;
	}

	public void setSez(int sez) {
		this.sez = sez;
	}

	public int getFytdNos() {
		return fytdNos;
	}

	public void setFytdNos(int fytdNos) {
		this.fytdNos = fytdNos;
	}

	public int getFyatdNos() {
		return fyatdNos;
	}

	public void setFyatdNos(int fyatdNos) {
		this.fyatdNos = fyatdNos;
	}

	public int getLxVsNosFytd() {
		return lxVsNosFytd;
	}

	public void setLxVsNosFytd(int lxVsNosFytd) {
		this.lxVsNosFytd = lxVsNosFytd;
	}

	public int getFyaNos() {
		return fyaNos;
	}

	public void setFyaNos(int fyaNos) {
		this.fyaNos = fyaNos;
	}

	public long getGrowthPotential() {
		return growthPotential;
	}

	public void setGrowthPotential(long growthPotential) {
		this.growthPotential = growthPotential;
	}
}
