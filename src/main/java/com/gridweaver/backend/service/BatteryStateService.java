package com.gridweaver.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import com.gridweaver.backend.entity.Device;
import com.gridweaver.backend.enums.BatteryEvent;
import com.gridweaver.backend.enums.BatteryState;
import com.gridweaver.backend.repository.DeviceRepository;

@Service
public class BatteryStateService {
	 @Autowired
	    private StateMachine<BatteryState, BatteryEvent> stateMachine;
	 
	 @Autowired
	    private DeviceRepository deviceRepository;
	 
	 public BatteryState changeState(BatteryEvent event) {
		  
		    stateMachine.start();
		  System.out.println("Current State: " + stateMachine.getState());
		  
		    
		    stateMachine.sendEvent(event);

		    return stateMachine.getState().getId();
		}
	 
	 public Device updateBatteryState(Long id, BatteryEvent event) {

		    Device device = deviceRepository.findById(id).orElseThrow();

		    stateMachine.start();
		    
		    if (device.getGridLoad() > 80) {

		        event = BatteryEvent.START_DISCHARGING;

		    } else if (device.getGridLoad() < 30) {

		        event = BatteryEvent.START_CHARGING;
		    }

		    stateMachine.sendEvent(event);

		    device.setBatteryState(stateMachine.getState().getId());

		    return deviceRepository.save(device);
		}

}
