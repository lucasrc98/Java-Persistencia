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

import com.br.metodos.LerFiles;
import com.br.metodos.TransformarFiles;
import com.br.models.Crime;
import com.br.models.Localizacao;



public class Aplicacao {
	
	private final static Integer QUANTIDADE_DADOS = 20;
	
	private static String FILE_CSV = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.csv";
	private static String FILE_XML = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.xml";
	private static String FILE_JSON = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.json";
	
	private static LerFiles leitor;
	private static TransformarFiles transformar;
	
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
			lerDados(leitorCsv, document, raiz);
			
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
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
//		
//		leitor = new LerFiles();
//		transformar = new TransformarFiles();
//
////		entidade = "livro";
////		raiz_XML = "acervo";
//		
//		String delimitador = ",";
//		
//		
//		leitor.lerCSV(FILE_CSV, delimitador);
		
	}
	
	private static void lerDados(BufferedReader leitorCsv, Document document, Element raiz) throws IOException {
		String linha;
		String[] data;
		leitorCsv.readLine();
		
		/// LER UMA QUANTIDADE DETERMINADA DE DADOS
		for (int i = 0; i < QUANTIDADE_DADOS; i++) {
			linha = leitorCsv.readLine(); // LER LINHA DO CSV
			data = linha.split(",");  // GERA UM ARRAY 
		
			Element crime = document.createElement("crime");
			
			
			crime.appendChild(createElement(document, "numero", data[0])); 
			crime.appendChild(createElement(document, "id", data[1]));
			crime.appendChild(createElement(document, "case_number", data[2]));
			crime.appendChild(createElement(document, "date", data[3]));
			crime.appendChild(createElement(document, "block", data[4]));
			crime.appendChild(createElement(document, "iucr", data[5]));
			crime.appendChild(createElement(document, "primary_type", data[6]));
			crime.appendChild(createElement(document, "description", data[7]));
			crime.appendChild(createElement(document, "arrest", data[8]));
			crime.appendChild(createElement(document, "domestic", data[9]));
			crime.appendChild(createElement(document, "beat", data[10]));
			crime.appendChild(createElement(document, "district", data[11]));
			crime.appendChild(createElement(document, "ward", data[12]));
			crime.appendChild(createElement(document, "fbi_code", data[13]));
			crime.appendChild(createElement(document, "year", data[14]));
			crime.appendChild(createElement(document, "updated_on", data[15]));
			

			Element localizacao = document.createElement("localizacao"); 
			
			crime.appendChild(createElement(document, "id", data[0])); 
			crime.appendChild(createElement(document, "location_description", data[1]));
			crime.appendChild(createElement(document, "community_area", data[2]));
			crime.appendChild(createElement(document, "x_coordinate", data[3]));
			crime.appendChild(createElement(document, "y_coordinate", data[4]));
			crime.appendChild(createElement(document, "latitude", data[5]));
			crime.appendChild(createElement(document, "longitude", data[6]));
			crime.appendChild(createElement(document, "location", data[7]));
			crime.appendChild(createElement(document, "id_loc", data[8]));
			
	
			crime.appendChild(localizacao);

			raiz.appendChild(crime);


		}
	}
	private static Element createElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
