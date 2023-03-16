package com.springboot.demo.kafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaStringConsumer.class);

	@KafkaListener(topics = "TOPIC-STRING-DEMO", groupId = "groupd_id")
	public void consume(String message, Acknowledgment ack) {
		log.info("Consuming message of type String: {}", message);
		ack.acknowledge();
	}
}
