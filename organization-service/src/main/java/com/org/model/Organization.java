package com.org.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "ORGANIZATION")
public class Organization {
	
	@Id
	@Column(name = "ORGANIZATION_ID")
	//@GeneratedValue(strategy = GenerationType.UUID)
	private String orgId;
	
	@Column(name = "ORG_NAME", nullable =  false)
	private String name;
	
	@Column(name = "CONTACT_NAME", nullable = false)
	private String contactName;
	
	@Column(name = "CONTACT_EMAIL", nullable = false)
	private String contactEmail;
	
	@Column(name = "CONTACT_NUMBER", nullable = false)
	private String contactPhone;
	

}
