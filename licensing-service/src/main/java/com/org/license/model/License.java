package com.org.license.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "LICENSE")
public class License {

	@Id
	@Column(name = "LICENSE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.UUID)
	private String licenseId;
	
	@Column(name = "DESCRIPTION", nullable =  false)
	private String description;
	
	@Column(name = "ORGANIZATION_ID", nullable = false)
	private String organizationId;
	
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;
	
	@Column(name = "LICENSE_TYPE", nullable = false)
	private String licenseType;
	
	@Column(name="comment")
	private String comment;

}
