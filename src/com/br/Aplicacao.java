package com.br;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.br.metodos.LerFiles;
import com.br.metodos.TransformarFiles;



public class Aplicacao {
	
	public static void main(String[] args) {

		String FILE_CSV = "/home/lucas/git/persistencia/Java-Persistencia/files/chicago-crimes.csv";
		
		BufferedReader conteudoCSV = null;
		
		String linha = "";
		
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
	
	
}
