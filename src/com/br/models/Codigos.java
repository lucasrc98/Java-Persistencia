package com.br.models;

public class Codigos {
	
	private String id_cod;
	private String case_number;
	private String iucr;
	private String beat;
	private String ward;
	private String fbi_code;
	
	
	public String getId_cod() {
		return id_cod;
	}
	public void setId_cod(String id_cod) {
		this.id_cod = id_cod;
	}
	public String getCase_number() {
		return case_number;
	}
	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}
	public String getIucr() {
		return iucr;
	}
	public void setIucr(String iucr) {
		this.iucr = iucr;
	}
	public String getBeat() {
		return beat;
	}
	public void setBeat(String beat) {
		this.beat = beat;
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
	
	@Override
	public String toString() {
		return "Codigo [case_number=" + case_number + ", iucr=" + iucr + ", beat=" + beat + ", ward=" + ward
				+ ", fbi_code=" + fbi_code + "]";
	}
	
	

}
