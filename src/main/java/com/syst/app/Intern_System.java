package com.syst.app;

import java.util.ArrayList;
import java.io.*;
import java.sql.*;

public class Intern_System extends inserir_ficha {

	private String nome;
	private String senha;
	private int idade;

	static String url = "Lista de fichas.txt";

	public Intern_System(String nome, String senha, int idade) {
		this.nome = nome;
		this.senha = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void fazerlista() throws IOException {

		String[] l = { "=============================================", "nome: " + this.nome,
				"idade: " + String.valueOf(this.idade), "senha: " + this.senha };
		try (FileWriter arquivo = new FileWriter("src/main/java/com/syst/app/Lista_de_fichas.txt", true)) {

			for (String line : l) {
				arquivo.write(line + System.lineSeparator());
			}
		} catch (IOException e) {

			System.err.print("erro!!, arquivo de registro não pode realizar registro");

		}

		System.out.print("nome: " + this.nome + "\nidade: " + String.valueOf(this.idade) + "\nsenha: " + this.senha
				+ "\n\nRegistrando...");
		setNome(null);
		setSenha(null);
		setIdade(0);

	}

	public void lerLista() {
		try (FileReader arquivo = new FileReader("src/main/java/com/syst/app/Lista_de_fichas.txt")) {
			
			ArrayList<String> nomes = new ArrayList<String>();
			ArrayList<String> senhas = new ArrayList<String>();
			BufferedReader file = new BufferedReader(arquivo);
			String line;
			
			while ((line = file.readLine()) != null) {
				
				if(line.startsWith("nome: ")) {
					nomes.add(line);
				}else if(line.startsWith("senha: ")) {
					senhas.add(line);
				}
				
			}
			
			
			for (String linha : nomes) {
				for(String linha2 : senhas) {
					
					if(linha.contains("nome: "+nome) && linha2.contains("senha: "+senha)) {
						System.out.print("Parabéns "+nome+", login realizado com sucesso!!");
						break;
					}else if(!linha.contains("nome: "+nome) && !linha2.contains("senha: "+senha)) {
						System.out.print(".");
					}
					
					
				}
			}
			
		} catch (IOException e) {
			System.err.println("Erro, conta não pode ser verificada\nresetando...");
		}
	}
	}
