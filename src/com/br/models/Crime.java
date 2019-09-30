package com.br.models;

public class Crime {


	private String id_crime;
	private String numero;
	private String date;
	private String block;
	private String primary_type;
	private String description;
	private String arrest;
	private String domestic;
	private String district;
	private String year;
	private String updated_on;
	
	Localizacao localizacaoObj;
	Codigos codigosObj;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	
	public String getId_crime() {
		return id_crime;
	}
	public void setId_crime(String id_crime) {
		this.id_crime = id_crime;
	}
	
	
	public Codigos getCodigosObj() {
		return codigosObj;
	}
	public void setCodigosObj(Codigos codigosObj) {
		this.codigosObj = codigosObj;
	}
	public Localizacao getLocalizacaoObj() {
		return localizacaoObj;
	}
	public void setLocalizacaoObj(Localizacao localizacaoObj) {
		this.localizacaoObj = localizacaoObj;
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

	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
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
		return "Crime [id_crime=" + id_crime + ", numero=" + numero + ", date=" + date + ", block=" + block
				+ ", primary_type=" + primary_type + ", description=" + description + ", arrest=" + arrest
				+ ", domestic=" + domestic + ", district=" + district + ", year=" + year + ", updated_on=" + updated_on
				+ ", localizacaoObj=" + localizacaoObj + ", codigosObj=" + codigosObj + "]";
	}	
	
}
