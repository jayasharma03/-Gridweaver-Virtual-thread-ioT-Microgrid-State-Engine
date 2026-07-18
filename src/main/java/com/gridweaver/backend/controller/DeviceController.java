package com.gridweaver.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gridweaver.backend.entity.Device;
import com.gridweaver.backend.service.DeviceService;

@RestController
@RequestMapping("/devices")
public class DeviceController {

	
	
	 @Autowired
	    private DeviceService service;

	    @PostMapping
	    public Device createDevice(@RequestBody Device device) {
	        return service.saveDevice(device);
	    }

	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}