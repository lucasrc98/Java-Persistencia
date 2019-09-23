package com.br.metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerFiles {
	
	public List<String[]> lerCSV(String localArquivo, String delemitador) {
		String linha;
		List<String[]> tuplas;
		BufferedReader buff = null;
		
		try {
			buff = new BufferedReader(new FileReader(localArquivo));
			tuplas = new ArrayList<>();
			while((linha = buff.readLine()) != null) {
				String[] palavras = linha.split(delemitador);
				tuplas.add(palavras);
			}
			buff.close();
			return tuplas;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
