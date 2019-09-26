package com.br.metodos;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.Attributes;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
//		crimeAtual.setInscricao(atts.getValue(0));
		crimes.add(crimeAtual);
		break;
		
		case "localizacao":
		localizacaoAtual = new Localizacao();
//		crimeAtual.add(localizacaoAtual);
		}
		
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		tagAtual = "";
	}
	
	
	
	
}

	

