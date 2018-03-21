package com.stratio.cockpit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "kpi")
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "Kpi entity", description = "Complete data of a entity Kpi")
@JsonIgnoreProperties(value = { "lastInvoiceDate" }, allowGetters = true)

public class Kpi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nos;

	@NotBlank
	private Long unitNOS;

	@NotBlank
	private int powerSegments;

	@NotBlank
	private int powerSKU;
	
	@NotBlank
	private int totalShareAllBrands;
	
	@NotBlank
	private int visibilityObjectives;
	
	@NotBlank
	private int mixIT;
	
	@NotBlank
	private int customerRightFrequency;
	
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastInvoiceDate;
	

	@NotBlank
	private String details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNos() {
		return nos;
	}

	public void setNos(String nos) {
		this.nos = nos;
	}

	public Long getUnitNOS() {
		return unitNOS;
	}

	public void setUnitNOS(Long unitNOS) {
		this.unitNOS = unitNOS;
	}

	public int getPowerSegments() {
		return powerSegments;
	}

	public void setPowerSegments(int powerSegments) {
		this.powerSegments = powerSegments;
	}

	public int getPowerSKU() {
		return powerSKU;
	}

	public void setPowerSKU(int powerSKU) {
		this.powerSKU = powerSKU;
	}

	public int getTotalShareAllBrands() {
		return totalShareAllBrands;
	}

	public void setTotalShareAllBrands(int totalShareAllBrands) {
		this.totalShareAllBrands = totalShareAllBrands;
	}

	public int getVisibilityObjectives() {
		return visibilityObjectives;
	}

	public void setVisibilityObjectives(int visibilityObjectives) {
		this.visibilityObjectives = visibilityObjectives;
	}

	public int getMixIT() {
		return mixIT;
	}

	public void setMixIT(int mixIT) {
		this.mixIT = mixIT;
	}

	public int getCustomerRightFrequency() {
		return customerRightFrequency;
	}

	public void setCustomerRightFrequency(int customerRightFrequency) {
		this.customerRightFrequency = customerRightFrequency;
	}

}
