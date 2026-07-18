package com.gridweaver.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	    
	    @GetMapping
	    public List<Device> getAllDevices() {
	        return service.getAllDevices();
	    }
	   
	    @PutMapping("/{id}")
	    public Device updateDevice(
	            @PathVariable Long id,
	            @RequestBody Device device) {

	        return service.updateDevice(id, device);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void deleteDevice(@PathVariable Long id) {
	        service.deleteDevice(id);
	    }
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}