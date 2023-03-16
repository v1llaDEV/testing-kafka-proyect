package com.springboot.demo.kafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.springboot.demo.kafka.entities.User;

@Component
public class KafkaUserProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaStringProducer.class);

	private final KafkaTemplate<String, User> kafkaUserTemplate;

	public KafkaUserProducer(@Qualifier("kafkaUserTemplate")KafkaTemplate<String, User> kafkaUserTemplate) {
		this.kafkaUserTemplate = kafkaUserTemplate;
	}

	public void sendMessage(User user) {
		log.info("Producing USER message: {}", user);
		this.kafkaUserTemplate.send("TOPIC-USER-DEMO", user);
	}
}
