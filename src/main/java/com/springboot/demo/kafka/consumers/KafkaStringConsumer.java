package com.springboot.demo.kafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaStringConsumer.class);
	
	@KafkaListener(topics = "TOPIC-DEMO", groupId="groupd_id")
	public void consume(String message) {
		log.info("Consuming message: {}", message);
	}
}
