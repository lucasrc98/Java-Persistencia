package com.br.models;

public class Localizacao {
	
	private String id_loc;
	private String location_description;
	private String community_area;
	private String x_coordinate;
	private String y_coordinate;
	private String latitude;
	private String longitude;
	private String location;
	
	
	public String getId_loc() {
		return id_loc;
	}
	public void setId_loc(String id_loc) {
		this.id_loc = id_loc;
	}
	public String getLocation_description() {
		return location_description;
	}
	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}
	public String getCommunity_area() {
		return community_area;
	}
	public void setCommunity_area(String community_area) {
		this.community_area = community_area;
	}
	public String getX_coordinate() {
		return x_coordinate;
	}
	public void setX_coordinate(String x_coordinate) {
		this.x_coordinate = x_coordinate;
	}
	public String getY_coordinate() {
		return y_coordinate;
	}
	public void setY_coordinate(String y_coordinate) {
		this.y_coordinate = y_coordinate;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	@Override
	public String toString() {
		return "Localizacao [id_loc = " + id_loc + ", location_description=" + location_description + ", community_area="
				+ community_area + ", x_coordinate=" + x_coordinate + ", y_coordinate=" + y_coordinate + ", latitude="
				+ latitude + ", longitude=" + longitude + ", location=" + location + "]";
	}
	
	
	
}
