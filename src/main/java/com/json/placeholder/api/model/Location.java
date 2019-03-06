package com.json.placeholder.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	private int id;
	private double lat;
	private double lng;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
}
