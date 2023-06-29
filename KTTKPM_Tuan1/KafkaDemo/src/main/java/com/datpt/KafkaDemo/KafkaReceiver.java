package com.datpt.KafkaDemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {

    @KafkaListener(topics = "topic_0")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Xử lý thông điệp nhận được
    }
}

