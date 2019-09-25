package com.br;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

		String FILE_CSV = "/home/lucas/git/persistencia/Java-Persistencia/files/chicago-crimes.csv";
		
		BufferedReader conteudoCSV = null;
		
		String linha = "";
		
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
		
		String csvSeparatorCampo = ",";
		

		try {
			
			conteudoCSV = new BufferedReader(new FileReader(FILE_CSV));
			
			while ((linha = conteudoCSV.readLine()) != null) {
				
				String[] moeda = linha.split(csvSeparatorCampo);
				
				System.out.println("[Data = " + moeda[0]
						+ " , Col = 1 " + moeda[1]
						+ " , Col = 2 " + moeda[2]
						+ " , Col = 3 " + moeda[3]
						+ " , Col = 4 " + moeda[4]
						+ " , Col = 5 " + moeda[5]
						+ " , Col = 6 " + moeda[6]
						+ " , Col = 7 " + moeda[7]
						+ " , Col = 8 " + moeda[8]
						+ " , Col = 9 " + moeda[9]
						+ " , Col = 10 " + moeda[10]
						+ " , Col = 11 " + moeda[11]
						+ " , Col = 12 " + moeda[12]
						+ " , Col = 13 " + moeda[13]
						+ " , Col = 14 " + moeda[14]
						+ " , Col = 15 " + moeda[15] + "]");						
			} 
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: \n" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBounds: \n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Erro	: \n" + e.getMessage());
		} finally {
			if (conteudoCSV != null) {
				try {
					conteudoCSV.close();
				} catch (IOException e) {
					System.out.println("IO Erro: \n" + e.getMessage());
				}
			}
		}
		
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
		
	
	
	private static void lerDados(BufferedReader leitorCsv, Document document, Element raiz) throws IOException {
		String linha;
		String[] data;
		leitorCsv.readLine();
		
		/// LER UMA QUANTIDADE DETERMINADA DE DADOS
		for (int i = 0; i < QUANTIDADE_DADOS; i++) {
			linha = leitorCsv.readLine(); // LER LINHA DO CSV
			data = linha.split(",");  // GERA UM ARRAY 
		
			Crime crime = new Crime();
			
			crime.setNumero(data[0]);
			crime.setId(data[1]);
			crime.setCase_number(data[2]);
			crime.setDate(data[3]);
			crime.setBlock(data[4]);
			crime.setIucr(data[5]);
			crime.setPrimary_type(data[6]);
			crime.setDescription(data[7]);
			crime.setArrest(data[8]);
			crime.setDomestic(data[9]);
			crime.setBeat(data[10]);
			crime.setDistrict(data[11]);
			crime.setWard(data[12]);
			crime.setFbi_code(data[13]);
			crime.setYear(data[14]);
			crime.setUpdated_on(data[15]);
			
			

			Element rimeElement = document.createElement("crime");
			
			Element nodeNumero = document.createElement("numero");
			nodeNumero.appendChild(document.createTextNode(crime.getNumero()));

			Element nodeId = document.createElement("id");
			nodeNumero.appendChild(document.createTextNode(crime.getId()));

			crimeElement.appendChild(nodeNumero); 
			crimeElement.appendChild(nodeId); 

			root.appendChild(crimeElement);
			
			
			
			crime.appendChild(localizacao);
			
			// CRIA NOVO ELEMENTO
			Element novoElemento = doc.createElement("novoElemento");
			novoElemento.appendChild(doc.createTextNode(data[0])); // ADICIONAR DADOS DO CSV NO XML

			// ADICIONA NOVO ELEMENTO COMO FILHO DO ELEMENTO ROOT(PRINCIPAL)		
			root.appendChild(novoElemento);
		}
	}
}
