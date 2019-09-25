package com.br.models;

public class Crime {

	private String numero;
	private String id;
	private String case_number;
	private String date;
	private String block;
	private String iucr;
	private String primary_type;
	private String description;
	private String arrest;
	private String domestic;
	private String beat;
	private String district;
	private String ward;
	private String fbi_code;
	private String year;
	private String updated_on;
	
	Localizacao localizacaoObj;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCase_number() {
		return case_number;
	}
	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getIucr() {
		return iucr;
	}
	public void setIucr(String iucr) {
		this.iucr = iucr;
	}
	public String getPrimary_type() {
		return primary_type;
	}
	public void setPrimary_type(String primary_type) {
		this.primary_type = primary_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArrest() {
		return arrest;
	}
	public void setArrest(String arrest) {
		this.arrest = arrest;
	}
	public String getDomestic() {
		return domestic;
	}
	public void setDomestic(String domestic) {
		this.domestic = domestic;
	}
	public String getBeat() {
		return beat;
	}
	public void setBeat(String beat) {
		this.beat = beat;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getFbi_code() {
		return fbi_code;
	}
	public void setFbi_code(String fbi_code) {
		this.fbi_code = fbi_code;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}
	
	@Override
	public String toString() {
		return "Crime [numero=" + numero + ", id=" + id + ", case_number=" + case_number + ", date=" + date + ", block="
				+ block + ", iucr=" + iucr + ", primary_type=" + primary_type + ", description=" + description
				+ ", arrest=" + arrest + ", domestic=" + domestic + ", beat=" + beat + ", district=" + district
				+ ", ward=" + ward + ", fbi_code=" + fbi_code + ", year=" + year + ", updated_on=" + updated_on
				+ ", localizacaoObj=" + localizacaoObj + "]";
	}
	
	
}
