package com.org.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class KafkaMessageEvent {
	
	private EventType eventType;
	private String organizationId;
	

}
