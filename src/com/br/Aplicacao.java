package com.br;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.br.metodos.CrimesSAX;
import com.br.metodos.LerFiles;
import com.br.metodos.TransformarFiles;
import com.br.models.Crime;
import com.br.models.Localizacao;



public class Aplicacao {
	
	private final static Integer QUANTIDADE_EXIBICAO = 30;
	
	private static String FILE_CSV = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.csv";
	private static String FILE_XML = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.xml";
	private static String FILE_JSON = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.json";
	
	
	public static void main(String[] args) {

		
		try {
			// ABRIR ARQUIVO CSV
			BufferedReader leitorCsv = new BufferedReader(new FileReader(FILE_CSV));
			
			
			// CRIAR FABRICA PARA GERAR NOVO DOCUMENTO XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Document document = docBuilder.newDocument();
			
			// CRIAR ELEMENTO PRINCIPAL DO XML
			Element raiz = document.createElement("crimes");
			document.appendChild(raiz);
			
			// LER DADOS DO CSV
			criaXML(leitorCsv, document, raiz);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transf = transformerFactory.newTransformer();
	        
	        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transf.setOutputProperty(OutputKeys.INDENT, "yes");
	        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        
	        // GRAVAR DADOS NO ARQUIVO XML
	        DOMSource source = new DOMSource(document);
	        File myFile = new File(FILE_XML);
	        StreamResult file = new StreamResult(myFile);
	        transf.transform(source, file);
	        
	        leitorCsv.close();
	        convertToJson();
	        
	        System.out.println("Deu bom na main");
			
		}catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	
	private static void criaXML(BufferedReader leitorCsv, Document document, Element raiz) throws IOException {
		String linha;
		String[] data;
		leitorCsv.readLine();
		
		// LER UMA QUANTIDADE DETERMINADA DE DADOS
		for (int i = 0; i < QUANTIDADE_EXIBICAO; i++) {
			linha = leitorCsv.readLine().replaceAll("\"", "");// LER LINHA DO CSV REMOVENDO AS ASPAS DUPLA
			data = linha.split(",");  // Delemitador
		
			// CRIA NOVO ELEMENTO
			Element crime = document.createElement("crime");
			
			// SETANDO OS ATRIBUTOS DO ELEMENTO

			crime.appendChild(createElement(document, "id_crime", data[1]));
			crime.appendChild(createElement(document, "numero", data[0])); 
			crime.appendChild(createElement(document, "date", data[3]));
			crime.appendChild(createElement(document, "block", data[4]));
			crime.appendChild(createElement(document, "primary_type", data[6]));
			crime.appendChild(createElement(document, "description", data[7]));
			crime.appendChild(createElement(document, "arrest", data[9]));
			crime.appendChild(createElement(document, "domestic", data[10]));
			crime.appendChild(createElement(document, "district", data[12]));
			crime.appendChild(createElement(document, "year", data[18]));
			crime.appendChild(createElement(document, "updated_on", data[19]));
			

			Element localizacao = document.createElement("localizacao"); 
			
			localizacao.appendChild(createElement(document, "id_loc", data[25])); 
			localizacao.appendChild(createElement(document, "location_description", data[8]));
			localizacao.appendChild(createElement(document, "community_area", data[14]));
			localizacao.appendChild(createElement(document, "x_coordinate", data[16]));
			localizacao.appendChild(createElement(document, "y_coordinate", data[17]));
			localizacao.appendChild(createElement(document, "latitude", data[20]));
			localizacao.appendChild(createElement(document, "longitude", data[21]));
			localizacao.appendChild(createElement(document, "location", data[22] + "," + data[23]));
			//localizacao.appendChild(createElement(document, "id_loc", data[]));
			
	
			Element codigos = document.createElement("codigos");
			
			codigos.appendChild(createElement(document, "id_cod", data[24]));
			codigos.appendChild(createElement(document, "case_number", data[2]));
			codigos.appendChild(createElement(document, "iucr", data[5]));
			codigos.appendChild(createElement(document, "beat", data[11]));
			codigos.appendChild(createElement(document, "ward", data[13]));
			codigos.appendChild(createElement(document, "fbi_code", data[15]));
			
			
			crime.appendChild(localizacao);
			crime.appendChild(codigos);
			
			raiz.appendChild(crime);
		}
		
		System.out.println("XML criado");
	}
	private static Element createElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
	
	private static void convertToJson() {
		CrimesSAX crimesSAX = new CrimesSAX();
		crimesSAX.fazerParsing(FILE_XML, FILE_JSON);
	}
}
