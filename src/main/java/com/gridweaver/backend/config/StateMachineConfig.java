package com.gridweaver.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.gridweaver.backend.enums.BatteryEvent;
import com.gridweaver.backend.enums.BatteryState;
@Configuration
@EnableStateMachine
public class StateMachineConfig  extends StateMachineConfigurerAdapter<BatteryState, BatteryEvent> {
	
	
	@Override
    public void configure(
            StateMachineStateConfigurer<BatteryState, BatteryEvent> states)
            throws Exception {

        states
            .withStates()
            .initial(BatteryState.IDLE)
            .state(BatteryState.CHARGING)
            .state(BatteryState.DISCHARGING)
            .state(BatteryState.FAULT);
        }
	@Override
	public void configure(
	        StateMachineTransitionConfigurer<BatteryState, BatteryEvent> transitions)
	        throws Exception {

	    transitions
	        .withExternal()
	        .source(BatteryState.IDLE)
	        .target(BatteryState.CHARGING)
	        .event(BatteryEvent.START_CHARGING)

	        .and()

	        .withExternal()
	        .source(BatteryState.CHARGING)
	        .target(BatteryState.DISCHARGING)
	        .event(BatteryEvent.START_DISCHARGING)

	        .and()

	        .withExternal()
	        .source(BatteryState.DISCHARGING)
	        .target(BatteryState.FAULT)
	        .event(BatteryEvent.SET_FAULT)

	        .and()

	        .withExternal()
	        .source(BatteryState.FAULT)
	        .target(BatteryState.IDLE)
	        .event(BatteryEvent.SET_IDLE);
	}


}
