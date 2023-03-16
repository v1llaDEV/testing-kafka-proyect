package com.springboot.demo.kafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaStringProducer.class);

	private final KafkaTemplate<String, String> kafkaStringTemplate;

	public KafkaStringProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, String> kafkaStringTemplate) {
		this.kafkaStringTemplate = kafkaStringTemplate;
	}

	public void sendMessage(String message) {
		log.info("Producing STRING message: {}", message);
		this.kafkaStringTemplate.send("TOPIC-STRING-DEMO", message);
	}

}
