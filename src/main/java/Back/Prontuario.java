package Back;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Prontuario {
	public static void EmitirProntuario(String Idade, String Nome, String Endereco, String Telefone, String Peso, String Altura, String Alergias, String Doencas, String Profissao, String Temperatura, String Pressao, String FreqCardiaca, String Sintomas, String Sexo){
		
		String titulo_prontuario = "Prontuario "+ Nome+".pdf";
		String pasta = "relatorios\\prontuarios\\";
		String caminho = pasta+titulo_prontuario;
		
		 try { 
			 //Cria a pasta caso ela não exista
	            File dir = new File(pasta);
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
		
		
		 Document documento = new Document(PageSize.A4);
	        // [DEBUG] System.out.println("Emitir prontuário foi chamado");
	        
	        try {
				PdfWriter.getInstance(documento, new FileOutputStream((caminho)));
				//ATENÇÃO! ESSE CÓDIGO TEM UM BUG EM QUE DOCUMENTOS DE MESMO NOME SE SOBRESCREVEM, CUIDADO AO UTILIZAR
				documento.open();
				documento.addTitle("Prontuário médico");
				documento.add(new Paragraph("Prontuário médico \n"));
				
				//adicionando as variáveis ao prontuário
				documento.add(new Paragraph("Paciente: " + Nome + " ;Data de emissão: __/__/____"));
				documento.add(new Paragraph("Idade: " + Idade));
				documento.add(new Paragraph("Telefone: " + Telefone));
				documento.add(new Paragraph("Peso: " + Peso + "Kg; Altura: " + Altura + "Cm; Sexo: " + Sexo));
				documento.add(new Paragraph("Alergias: " + Alergias));
				documento.add(new Paragraph("Comorbidades: " + Doencas));
				documento.add(new Paragraph("Profissao: " + Profissao));
				documento.add(new Paragraph("Temperatura: " + Temperatura + "Cº; Pressao Arterial: " + Pressao + "; Frequência Cardíaca: " + FreqCardiaca));
				documento.add(new Paragraph("Sintomas e queixas: " + Sintomas));
				
				documento.add(new Paragraph("Solicitações médicas:____________________________________________________________________________________________________________________ "));
				
				
			} catch (Exception e) {
			
				e.printStackTrace();
			} finally {
				documento.close();
			}
	        
	        try {
				Desktop.getDesktop().open(new File(caminho));
			} catch (Exception e) {
				e.printStackTrace();
			};
	}
}
