package com.gridweaver.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Zone {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String zoneName;

	    private Double currentLoad;

	    private Double availablePower;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getZoneName() {
			return zoneName;
		}

		public void setZoneName(String zoneName) {
			this.zoneName = zoneName;
		}

		public Double getCurrentLoad() {
			return currentLoad;
		}

		public void setCurrentLoad(Double currentLoad) {
			this.currentLoad = currentLoad;
		}

		public Double getAvailablePower() {
			return availablePower;
		}

		public void setAvailablePower(Double availablePower) {
			this.availablePower = availablePower;
		}

	 

}
