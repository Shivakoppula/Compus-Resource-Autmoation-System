package com.project.compusResurce_Automation_System.Entities_Class;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Grievance {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String raisedBy;
    private String status;
	public Grievance(String description, String raisedBy, String status) {
		super();
		this.description = description;
		this.raisedBy = raisedBy;
		this.status = status;
	}
	public Grievance(Long id, String description, String raisedBy, String status) {
		super();
		this.id = id;
		this.description = description;
		this.raisedBy = raisedBy;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
