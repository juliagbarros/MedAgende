package Back;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalTime;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Consulta {
	public static void EmitirComprovanteConsulta(String Nome_Med, String Nome_Pac, String Especialidade, Date data, LocalTime horario) {
		 Document documento = new Document(PageSize.A4);
	        // [DEBUG] System.out.println("Emitir atestado foi chamado");
	        String titulo_pdf = "Consulta_"+ Nome_Pac +".pdf";
	        String pasta = "relatorios\\consultas\\";
	        String caminho = pasta + titulo_pdf;
	        
	        
	        try {
	            // Garante que o diretório de destino exista antes de tentar salvar
	            File dir = new File(pasta);
	            if (!dir.exists()) {
	                dir.mkdirs(); // Cria a pasta
	            }
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
	        
	        try {
				PdfWriter.getInstance(documento, new FileOutputStream(caminho));
				//ATENÇÃO! ESSE CÓDIGO TEM UM BUG EM QUE DOCUMENTOS DE MESMO NOME SE SOBRESCREVEM, CUIDADO AO UTILIZAR
				documento.open();
				documento.addTitle("Comprovante de Agendamento");
				documento.add(new Paragraph("Comprovante de agendamento \n"));
				documento.add(new Paragraph("Paciente: " + Nome_Pac));
				documento.add(new Paragraph("Médico: " + Nome_Med));
				documento.add(new Paragraph("Especialidade: " + Especialidade));
				documento.add(new Paragraph("Data Agendada: " + data));
				documento.add(new Paragraph("Horário Agendado: " + horario));
				
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
	};

}
