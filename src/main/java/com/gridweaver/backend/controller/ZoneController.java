package com.gridweaver.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gridweaver.backend.entity.Zone;
import com.gridweaver.backend.repository.ZoneRepository;
import com.gridweaver.backend.service.RegionalBalancingService;

@RestController
@RequestMapping("/zones")
public class ZoneController {

	@Autowired
	private ZoneRepository zoneRepository;
    @Autowired
    private RegionalBalancingService balancingService;
 
 // Add Zone
    @PostMapping
    public Zone addZone(@RequestBody Zone zone) {
        return zoneRepository.save(zone);
    }

    // Get All Zones
    @GetMapping
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    // Balance Power
    @PostMapping("/balance")
    public String balancePower() {
        return balancingService.balancePower();
    }
}