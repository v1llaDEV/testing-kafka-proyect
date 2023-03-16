package com.springboot.demo.kafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaStringProducer.class);

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public KafkaStringProducer(@Qualifier("kafkaTemplate") KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		log.info("Producing STRING message: {}", message);
		this.kafkaTemplate.send("TOPIC-STRING-DEMO", message);
	}

}
