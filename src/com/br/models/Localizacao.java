package com.br.models;

public class Localizacao {
	
	private int id;
	private String location_description;
	private String community_area;
	private Float x_coordinate;
	private Float y_coordinate;
	private Float latitude;
	private Float longitude;
	private String location;
	private int id_loc;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Float getX_coordinate() {
		return x_coordinate;
	}
	public void setX_coordinate(Float x_coordinate) {
		this.x_coordinate = x_coordinate;
	}
	public Float getY_coordinate() {
		return y_coordinate;
	}
	public void setY_coordinate(Float y_coordinate) {
		this.y_coordinate = y_coordinate;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getId_loc() {
		return id_loc;
	}
	public void setId_loc(int id_loc) {
		this.id_loc = id_loc;
	}
	
	@Override
	public String toString() {
		return "Localizacao [id=" + id + ", location_description=" + location_description + ", community_area="
				+ community_area + ", x_coordinate=" + x_coordinate + ", y_coordinate=" + y_coordinate + ", latitude="
				+ latitude + ", longitude=" + longitude + ", location=" + location + ", id_loc=" + id_loc + "]";
	}
	
	
	
}
