package com.gridweaver.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridweaver.backend.entity.Device;
import com.gridweaver.backend.repository.DeviceRepository;

@Service
public class DeviceService {
	 @Autowired
	    private DeviceRepository repository;

	    public Device saveDevice(Device device) {
	        return repository.save(device);
	    }

	    public List<Device> getAllDevices() {
	        return repository.findAll();
	    }
	
	
	
	
	
	
	
	
	
}


