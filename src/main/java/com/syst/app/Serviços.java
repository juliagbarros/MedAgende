package com.syst.app;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Serviços extends inserir_ficha {
	
	ArrayList<String> servicos;

	public Serviços(ArrayList<String> servicos) {
		this.servicos = servicos;
		}

	public ArrayList<String> getServicos() {
		return servicos;
	}

	public void setServicos(ArrayList<String> servicos) {
		this.servicos = servicos;
	}
	
	public void apresentar() {
		try(FileReader caminho = new FileReader("./meme/Lista_de_serviços.txt");){
			BufferedReader arquivo = new BufferedReader(caminho);
			String line;
			String lines;
			while ((line = arquivo.readLine()) != null) {
				if(line.startsWith("entregas")) {
					servicos.add(line);
				}else if(line.startsWith("cardapio")) {
					servicos.add(line);
				}
			}
		}catch(IOException e){
			//wait for the code
		}
	}
	

}
