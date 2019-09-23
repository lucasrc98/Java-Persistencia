package com.br;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.br.metodos.LerFiles;
import com.br.metodos.TransformarFiles;



public class Aplicacao {
	
	
	private static String ARQUIVO ;
	
	private static String FILE_CSV = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.csv";
	private static String FILE_XML = "D:\\Git\\Java-Persistencia\\files\\chicago-crimes.xml";

	
	private static LerFiles leitor;
	private static TransformarFiles transformar;
	
	public static void main(String[] args) {

		
		leitor = new LerFiles();
		transformar = new TransformarFiles();

//		entidade = "livro";
//		raiz_XML = "acervo";
		
		String delimitador = ",";
		
		
		leitor.lerCSV(FILE_CSV, delimitador);
		
	}
	
	public static void exemplo12LerProperties() throws IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(ARQUIVO));
		
		String aluno = prop.getProperty("aluno");
		String faculdade = prop.getProperty("faculdade");
		double salario = Double.parseDouble(prop.getProperty("salario"));
		
		
		System.out.println(aluno);
		System.out.println(faculdade);
		System.out.println(salario);
	}
}
