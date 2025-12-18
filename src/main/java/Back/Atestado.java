package Back;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Atestado {
	public static void EmitirAtestado() {
		 Document documento = new Document(PageSize.A4);
	        // [DEBUG] System.out.println("Emitir atestado foi chamado");
	        String nome_medico = "Dr.Lorem";
	        String titulo_pdf = "Receita "+ nome_medico +".pdf";
	        String pasta = "relatorios\\atestados\\";
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
				documento.addTitle("Atestado médico");
				documento.add(new Paragraph("Atestado médico \n"));
				documento.add(new Paragraph("Atesto para os devidos fins que _______________________________________, portador do RG ____________ esteve em consulta médica neste consultório, no dia ____/____/_______, do período das ____ às ____. \n\n\n________, ________ de _________ de ____"));
				documento.add(new Paragraph(600, "Ass.:_____________________________________________________"));
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
