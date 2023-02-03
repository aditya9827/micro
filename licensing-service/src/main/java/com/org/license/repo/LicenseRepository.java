package com.org.license.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.license.model.License;

public interface LicenseRepository extends CrudRepository<License, String>{
	
	public List<License> findByOrganizationId(String organizationId);
    public License findByOrganizationIdAndLicenseId(String organizationId,String licenseId);
    
    public License findByLicenseId(String licenseId);

}
