package com.org.license.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.license.feign.OrganizationOpenFeign;
import com.org.license.model.License;
import com.org.license.model.Organization;
import com.org.license.repo.LicenseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private OrganizationOpenFeign openFeign;

	public License getLicense(String licenseId, String organizationName){
		License license = licenseRepository.findByLicenseId(licenseId);
		if (null == license) {
			throw new IllegalArgumentException("License not present");	
		}
		
		log.info("Getting Organization Data");
		//return license.withComment(config.getProperty());
		Organization organization = openFeign.getOrganization(organizationName);
		license.setOrganizationId(organization.getOrgId());
		return license;
	}

	public License createLicense(License license, String organizationName){
		//license.setLicenseId(UUID.randomUUID().toString());
		
		log.info("Getting Organization Data");
		//return license.withComment(config.getProperty());
		Organization organization = openFeign.getOrganization(organizationName);
		license.setOrganizationId(organization.getOrgId());
		
		licenseRepository.save(license);

		//return license.withComment(config.getProperty());
		return license;
	}

	public License updateLicense(License license){
		licenseRepository.save(license);

		//return license.withComment(config.getProperty());
		return license;
	}

	public String deleteLicense(String licenseId){
		Optional<License> licenseById = this.licenseRepository.findById(licenseId);
	
		licenseById.ifPresent(i -> {
			i.setComment("License Deleted");
			licenseRepository.save(i);
		});
		return "License Deleted";
	}
	
	

}
