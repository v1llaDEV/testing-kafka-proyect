package com.springboot.demo.kafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.springboot.demo.kafka.entities.User;

@Component
public class KafkaUserConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaUserConsumer.class);
	
	@KafkaListener(topics = "TOPIC-USER-DEMO", groupId="groupd_id")
	public void consume(User user) {
		log.info("Consuming message of type USER: {}", user);
	}
}
