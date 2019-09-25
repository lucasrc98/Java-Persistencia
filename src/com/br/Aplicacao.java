package com.br;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
			
			
//			crime.appendChild(createElement(document, "numero", data[0])); 
//			crime.setId(data[1]);
//			crime.setCase_number(data[2]);
//			crime.setDate(data[3]);
//			crime.setBlock(data[4]);
//			crime.setIucr(data[5]);
//			crime.setPrimary_type(data[6]);
//			crime.setDescription(data[7]);
//			crime.setArrest(data[8]);
//			crime.setDomestic(data[9]);
//			crime.setBeat(data[10]);
//			crime.setDistrict(data[11]);
//			crime.setWard(data[12]);
//			crime.setFbi_code(data[13]);
//			crime.setYear(data[14]);
//			crime.setUpdated_on(data[15]);
			
			

//			Element rimeElement = document.createElement("crime");
//			Element rimeElement = document.createElement("localizacao");
//			
//			Element nodeNumero = document.createElement("numero");
//			nodeNumero.appendChild(document.createTextNode(crime.getNumero()));
//
//			Element nodeId = document.createElement("id");
//			nodeNumero.appendChild(document.createTextNode(crime.getId()));
//
//			crimeElement.appendChild(nodeNumero); 
//			crimeElement.appendChild(nodeId); 
//
//			root.appendChild(crimeElement);
//			
//			
//			
//			crime.appendChild(localizacao);
//			
//			// CRIA NOVO ELEMENTO
//			Element novoElemento = doc.createElement("novoElemento");
//			novoElemento.appendChild(doc.createTextNode(data[0])); // ADICIONAR DADOS DO CSV NO XML
//
//			// ADICIONA NOVO ELEMENTO COMO FILHO DO ELEMENTO ROOT(PRINCIPAL)		
//			root.appendChild(novoElemento);
		}
	}
	private static Element createElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
