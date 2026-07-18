package com.gridweaver.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Device {

    @Id
    private Long id;

    private String deviceId;
    private String deviceName;
    private String status;
    private Double powerOutput;
    private String location;
    private String batteryState;
}
