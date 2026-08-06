package com.gridweaver.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridweaver.backend.entity.Zone;
import com.gridweaver.backend.repository.ZoneRepository;

@Service
public class RegionalBalancingService {

    @Autowired
    private ZoneRepository zoneRepository;

    public String balancePower() {

        Zone zoneA = zoneRepository.findById(1L).orElseThrow();
        Zone zoneB = zoneRepository.findById(2L).orElseThrow();

        if (zoneA.getCurrentLoad() > 80 &&
            zoneB.getAvailablePower() > 20) {

            zoneA.setAvailablePower(zoneA.getAvailablePower() + 20);
            zoneB.setAvailablePower(zoneB.getAvailablePower() - 20);

            zoneRepository.save(zoneA);
            zoneRepository.save(zoneB);

            return "Power transferred from Zone B to Zone A";
        }

        return "No balancing required";
    }

}
