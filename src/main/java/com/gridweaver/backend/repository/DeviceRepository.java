package com.gridweaver.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gridweaver.backend.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}