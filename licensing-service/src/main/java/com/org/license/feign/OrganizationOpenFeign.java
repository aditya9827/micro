package com.org.license.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.license.model.Organization;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "org-service")
public interface OrganizationOpenFeign {
	
	@CircuitBreaker(name = "org_service")
	@GetMapping(path = "/v1/organization/orgName/{orgName}")
	public Organization getOrganization(@PathVariable ("orgName") String orgId);
	
	
	
	

}
