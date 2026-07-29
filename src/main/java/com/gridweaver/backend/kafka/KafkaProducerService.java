package com.gridweaver.backend.kafka;

	


	import org.springframework.kafka.core.KafkaTemplate;
	import org.springframework.stereotype.Service;

	@Service
	public class KafkaProducerService {

	    private final KafkaTemplate<String, String> kafkaTemplate;

	    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public void sendMessage(String message) {
	        kafkaTemplate.send("device-events", message);
	        System.out.println("Message Sent: " + message);
	    }
	}

