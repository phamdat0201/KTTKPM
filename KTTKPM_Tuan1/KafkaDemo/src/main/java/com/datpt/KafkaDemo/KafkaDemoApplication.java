package com.datpt.KafkaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KafkaDemoApplication {

	private final KafkaSender kafkaSender;

    @Autowired
    public KafkaDemoApplication(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}
	public void sendExampleMessage() {
        String topic = "<your-topic>";
        String message = "Hello Kafka!";
        kafkaSender.sendMessage(topic, message);
    }
}
