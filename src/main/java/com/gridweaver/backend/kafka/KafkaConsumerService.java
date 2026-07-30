package com.gridweaver.backend.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.gridweaver.backend.enums.BatteryEvent;
import com.gridweaver.backend.service.BatteryStateService;

@Service
public class KafkaConsumerService {
	
	private final BatteryStateService batteryStateService;

	public KafkaConsumerService(BatteryStateService batteryStateService) {
	    this.batteryStateService = batteryStateService;
	}
	 

    @KafkaListener(topics = "device-events", groupId = "device-group")
    public void consume(String message) {
        System.out.println("Received Message: " + message);
        
        
        String[] data = message.split(",");

        Long deviceId = Long.parseLong(data[0]);

        BatteryEvent event = BatteryEvent.valueOf(data[1]);

        batteryStateService.updateBatteryState(deviceId, event);

        System.out.println("Battery State Updated Successfully");
    }
       
        
                
    }
