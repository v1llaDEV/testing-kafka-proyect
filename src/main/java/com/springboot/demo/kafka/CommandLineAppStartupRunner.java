package com.springboot.demo.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.demo.kafka.entities.User;
import com.springboot.demo.kafka.producers.KafkaStringProducer;
import com.springboot.demo.kafka.producers.KafkaUserProducer;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	private final KafkaStringProducer stringProducer;

	private final KafkaUserProducer userProducer;

	public CommandLineAppStartupRunner(KafkaStringProducer stringProducer, KafkaUserProducer userProducer) {
		this.stringProducer = stringProducer;
		this.userProducer = userProducer;
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 5; i++) {
			stringProducer.sendMessage("Hello kafka !! " + i);
			userProducer.sendMessage(new User("Adrián " + i));
			Thread.sleep(2000);
		}
	}
}
