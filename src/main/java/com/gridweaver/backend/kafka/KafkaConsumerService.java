package com.gridweaver.backend.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class KafkaConsumerService {
	
	
	 @PostConstruct
	    public void init() {
	        System.out.println("Kafka Consumer Loaded...");
	    }

    @KafkaListener(topics = "device-events", groupId = "device-group")
    public void consume(String message) {
        System.out.println("Received Message: " + message);
    }
}