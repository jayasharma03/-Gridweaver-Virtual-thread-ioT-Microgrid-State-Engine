package com.gridweaver.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import com.gridweaver.backend.enums.BatteryEvent;
import com.gridweaver.backend.enums.BatteryState;

@Service
public class BatteryStateService {
	 @Autowired
	    private StateMachine<BatteryState, BatteryEvent> stateMachine;
	 public BatteryState changeState(BatteryEvent event) {
		  stateMachine.start();
		  System.out.println("Current State: " + stateMachine.getState());
		    stateMachine.sendEvent(event);

		    return stateMachine.getState().getId();
		}

}
