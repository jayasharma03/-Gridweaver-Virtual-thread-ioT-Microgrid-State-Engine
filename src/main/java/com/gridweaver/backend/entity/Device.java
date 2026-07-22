package com.gridweaver.backend.entity;

import com.gridweaver.backend.enums.BatteryState;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String deviceId;
	private String status;
	private Double powerOutput;
	private String location;
	@Enumerated(EnumType.STRING)
	private BatteryState batteryState;
	private Double gridLoad;
	public Double getGridLoad() {
		return gridLoad;
	}
	public void setGridLoad(Double gridLoad) {
		this.gridLoad = gridLoad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPowerOutput() {
		return powerOutput;
	}
	public void setPowerOutput(Double powerOutput) {
		this.powerOutput = powerOutput;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public BatteryState getBatteryState() {
	    return batteryState;
	}

	public void setBatteryState(BatteryState batteryState) {
	    this.batteryState = batteryState;
	}
}
