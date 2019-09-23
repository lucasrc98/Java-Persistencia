package com.br.metodos;

import java.io.File;
import java.io.IOException;

public class CriarFiles {
	private File file;
	
	public String criarArquivoCSV(String dir) {
		file = new File(dir);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dir;
	}
}
