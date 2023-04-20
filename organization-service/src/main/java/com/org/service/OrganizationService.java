package com.org.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.Organization;
import com.org.repo.OrganizationRepository;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	public Organization getOrganizationById(String orgId) {
		Optional<Organization> org = this.organizationRepository.findById(orgId);
		
		if(org.isPresent()) {
			return org.get();
		} 
		
		return null;
	}
	
	public Organization createOrg(Organization org) {
		//org.setOrgId(UUID.randomUUID().toString());
		return this.organizationRepository.save(org);
	}
	
	public List<Organization> getByName(String name) {
		return this.organizationRepository.findByName(name);
	}

}
