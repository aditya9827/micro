package com.org.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, String>{
	
	List<Organization> findByName(String name);

}
