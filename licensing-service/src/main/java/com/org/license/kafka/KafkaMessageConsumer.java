package com.org.license.kafka;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.org.license.model.KafkaMessageEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaMessageConsumer {

	//@Bean
	public Consumer<KafkaMessageEvent> organizationEventConsumer() {

		return message -> log.info("Incoming Message : {}, EventType : {}", message.getOrganizationId(),
				message.getEventType());
	}
}
