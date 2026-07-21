package com.gridweaver.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gridweaver.backend.enums.BatteryEvent;
import com.gridweaver.backend.enums.BatteryState;
import com.gridweaver.backend.service.BatteryStateService;

@RestController
public class BatteryController {
	@Autowired
    private BatteryStateService batteryStateService;

    @GetMapping("/battery/{event}")
    public BatteryState changeBatteryState(
            @PathVariable BatteryEvent event) {

        return batteryStateService.changeState(event);
    }

}
