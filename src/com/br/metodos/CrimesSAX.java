package com.br.metodos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.br.models.Codigos;
import com.br.models.Crime;
import com.br.models.Localizacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CrimesSAX extends DefaultHandler {
	
	private String pathJson;

	private String tagAtual;

	private List<Crime> crimes;
	
	private Crime crimeAtual;
	private Localizacao localizacaoAtual;
	private Codigos codigosAtual;
	
	public CrimesSAX() {
		super();
		this.crimes = new ArrayList<Crime>();
	}
	
	public void fazerParsing(String pathArq, String pathJson) {
		this.pathJson = pathJson;

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;

		try {

			saxParser = factory.newSAXParser();
			saxParser.parse(pathArq, this);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void startDocument() {
	}
	
	public void endDocument() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		try {
			mapper.writeValue(new File(pathJson), crimes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		tagAtual = qName;
		
		switch (qName) {
		case "crime":
		crimeAtual = new Crime();
		crimes.add(crimeAtual);
		break;
		
		case "localizacao":
		localizacaoAtual = new Localizacao();
		crimeAtual.setLocalizacaoObj(localizacaoAtual);
		break;
		
		case "codigos":
			codigosAtual = new Codigos();
			crimeAtual.setCodigosObj(codigosAtual);
			break;
		}
		
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		tagAtual = "";
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {

		String texto = new String(ch, start, length);

		switch (tagAtual) {
		case "id_crime":
			crimeAtual.setId_crime(texto);
			break;
		case "numero":
			crimeAtual.setNumero(texto);
			break;
	
		case "date":
			crimeAtual.setDate(texto);
			break;
		
		case "primary_type":
			crimeAtual.setPrimary_type(texto);
			break;
		case "description":
			crimeAtual.setDescription(texto);
			break;
		case "arrest":
			crimeAtual.setArrest(texto);
			break;
		case "domestic":
			crimeAtual.setDomestic(texto);
			break;
		
		case "district":
			crimeAtual.setDistrict(texto);
			break;
		
		case "year":
			crimeAtual.setYear(texto);
			break;
		case "updated_on":
			crimeAtual.setUpdated_on(texto);
			break;
		
		
		case "id_loc":
			localizacaoAtual.setId_loc(texto);
			break;
		case "location_description":
			localizacaoAtual.setLocation_description(texto);
			break;			
		case "community_area":
			localizacaoAtual.setCommunity_area(texto);
			break;			
		case "x_coordinate":
			localizacaoAtual.setX_coordinate(texto);
			break;		
		case "y_coordinate":
			localizacaoAtual.setY_coordinate(texto);
			break;	
		case "latitude":
			localizacaoAtual.setLatitude(texto);
			break;	
		case "longitude":
			localizacaoAtual.setLongitude(texto);
			break;
		case "location":
			localizacaoAtual.setLocation(texto);
			break;
			
		case "id_cod":
			codigosAtual.setId_cod(texto);
			break;
		case "case_number":
			codigosAtual.setCase_number(texto);
			break;
		case "iucr":
			codigosAtual.setIucr(texto);
			break;
		case "beat":
			codigosAtual.setBeat(texto);
			break;
		case "ward":
			codigosAtual.setWard(texto);
			break;
		case "fbi_code":
			codigosAtual.setFbi_code(texto);
			break;
			
			
		default:
			break;
		}
	}
	
	
	
	
}

	

