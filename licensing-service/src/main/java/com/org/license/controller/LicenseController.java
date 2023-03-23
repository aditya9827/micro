package com.org.license.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.license.model.License;
import com.org.license.service.LicenseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="v1/organization/{organizationName}/license")
//@RequestMapping(path= "v1/license")
@Slf4j
public class LicenseController {
	
	@Autowired
	private LicenseService licenseService;

	@GetMapping(value="/{licenseId}")
	public ResponseEntity<License> getLicense( @PathVariable("organizationName") String organizationName,
			@PathVariable("licenseId") String licenseId) {
		log.info("Getting License value");
		License license = licenseService.getLicense(licenseId, organizationName);
//		license.add( 
//				linkTo(methodOn(LicenseController.class).getLicense(organizationId, license.getLicenseId())).withSelfRel(),
//				linkTo(methodOn(LicenseController.class).createLicense(organizationId, license, null)).withRel("createLicense"),
//				linkTo(methodOn(LicenseController.class).updateLicense(organizationId, license)).withRel("updateLicense"),
//				linkTo(methodOn(LicenseController.class).deleteLicense(organizationId, license.getLicenseId())).withRel("deleteLicense")
//		);
//		
		return ResponseEntity.ok(license);
	}

	@PutMapping
	public ResponseEntity<License> updateLicense(@RequestBody License request) {
		return ResponseEntity.ok(licenseService.updateLicense(request));
	}
	
	@PostMapping
	public ResponseEntity<License> createLicense(@PathVariable("organizationName") String organizationName, @RequestBody License request) {
		log.info("Adding a new license");
		return ResponseEntity.ok(licenseService.createLicense(request, organizationName));
	}

	@DeleteMapping(value="/{licenseId}")
	public ResponseEntity<String> deleteLicense(@PathVariable("licenseId") String licenseId) {
		log.info("Deleting License ");
		return ResponseEntity.ok(licenseService.deleteLicense(licenseId));
	}

}
