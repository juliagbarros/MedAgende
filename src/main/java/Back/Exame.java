package Back;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Exame {
	public static void EmitirExame(String Nome_Pac, String Idade, String Endereco_Pac, String Sexo, String Telefone, String Nome_Med, String CRM, String Endereco_Clinica, String Exames, String Obs, String Data_Sol) {
		String titulo_solicitacao = "Sol_Exame "+ Nome_Pac+".pdf";
		String pasta = "relatorios\\sol_exames\\";
		String caminho = pasta+titulo_solicitacao;
		
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
				documento.add(new Paragraph("Paciente: " + Nome_Pac));
				documento.add(new Paragraph("Idade: " + Idade));
				documento.add(new Paragraph("Telefone: " + Telefone));
				documento.add(new Paragraph("Sexo: " + Sexo));
				documento.add(new Paragraph("Endereço do Paciente: " + Endereco_Pac));
				
				
				documento.add(new Paragraph("Nome do médico solicitante: " + Nome_Med));
				documento.add(new Paragraph("CRM: " + CRM));
				documento.add(new Paragraph("Endereço da Clínica: " + Endereco_Clinica));
				documento.add(new Paragraph("Data da solicitação: " + Data_Sol));
				documento.add(new Paragraph("Exames Solicitados: " + Exames));
				documento.add(new Paragraph("Observações adicionais: " + Obs));
				
				
				documento.add(new Paragraph("Ass:____________________________________________________________________________________________________________________ "));
				
				
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
