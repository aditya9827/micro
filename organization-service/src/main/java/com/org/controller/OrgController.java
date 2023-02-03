package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.EventType;
import com.org.model.KafkaMessageEvent;
import com.org.model.Organization;
import com.org.service.OrganizationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/v1/organization")
@Slf4j
public class OrgController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private StreamBridge streamBridge;
	
	@GetMapping(path = "orgId/{organizationId}")
	public ResponseEntity<Organization> getOrganization(@PathVariable ("organizationId") String orgId){
		Organization organizationById = this.organizationService.getOrganizationById(orgId);
		
		return ResponseEntity.ok(organizationById);
	}
	
	@GetMapping(path = "orgName/{orgName}")
	public ResponseEntity<Organization> getOrgByName(@PathVariable ("orgname") String orgName){
		return ResponseEntity.ok(this.organizationService.getByName(orgName));
	}
	
	@PostMapping()
	public ResponseEntity<Organization> createOrg(@RequestBody Organization org){
		log.info("Creating new Organization");
		Organization newOrg = this.organizationService.createOrg(org);
		
		log.info("Publishing message to Kafka Broker");
		KafkaMessageEvent kafkaEvent = KafkaMessageEvent.builder()
														.eventType(EventType.CREATED)
														.organizationId(newOrg.getOrgId())
														.build();
		
		streamBridge.send("producer-out-0", kafkaEvent);
		return ResponseEntity.ok(newOrg);
	}
	
	

}
