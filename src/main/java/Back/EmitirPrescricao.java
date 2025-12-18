package Back;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class EmitirPrescricao {
    
    private String nomeMedico;
    private String nomePaciente;
    private String diagnostico;
    private String medicamentos;
    private String descricao;
    private String frequencia;
    private String dataInicio;
    private String dataTermino;
    private String convenio;
    private String alergias;
    private String crmMedico;
    
    public EmitirPrescricao(String nomeMedico, String nomePaciente, String diagnostico, 
                           String medicamentos, String descricao, String frequencia,
                           String dataInicio, String dataTermino, String convenio, 
                           String alergias, String crmMedico) {
        this.nomeMedico = nomeMedico;
        this.nomePaciente = nomePaciente;
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
        this.descricao = descricao;
        this.frequencia = frequencia;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.convenio = convenio;
        this.alergias = alergias;
        this.crmMedico = crmMedico;
    }
    
    public boolean emitir() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = sdf.format(new Date());
            String nomeArquivo = "Prescricao_" + nomePaciente.replace(" ", "_") + "_" + timestamp + ".pdf";
            
            String pasta = "relatorios/prescricoes/";
            String caminho = pasta + nomeArquivo;
            
            File dir = new File(pasta);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            Document documento = new Document(PageSize.A4);
            PdfWriter.getInstance(documento, new FileOutputStream(caminho));
            
            documento.open();
            
            documento.add(new Paragraph("PRESCRIÇÃO MÉDICA\n"));
            documento.add(new Paragraph("_______________________________________________________________________\n\n"));
            
            documento.add(new Paragraph("MÉDICO PRESCRITOR:"));
            documento.add(new Paragraph("Nome: " + nomeMedico));
            if (crmMedico != null && !crmMedico.trim().isEmpty()) {
                documento.add(new Paragraph("CRM: " + crmMedico));
            }
            
            documento.add(new Paragraph("\nPACIENTE:"));
            documento.add(new Paragraph("Nome: " + nomePaciente));
            if (convenio != null && !convenio.trim().isEmpty()) {
                documento.add(new Paragraph("Convênio: " + convenio));
            }
            
            if (alergias != null && !alergias.trim().isEmpty() && !alergias.equalsIgnoreCase("nenhuma")) {
                documento.add(new Paragraph("\nALERGIAS CONHECIDAS:"));
                documento.add(new Paragraph(alergias));
            }
            
            documento.add(new Paragraph("\nDIAGNÓSTICO/INDICAÇÃO:"));
            documento.add(new Paragraph(diagnostico));
            
            documento.add(new Paragraph("\nMEDICAMENTOS PRESCRITOS:"));
            documento.add(new Paragraph(medicamentos));
            
            documento.add(new Paragraph("\nPOSOLOGIA:"));
            if (frequencia != null && !frequencia.trim().isEmpty()) {
                documento.add(new Paragraph("Frequência: " + frequencia));
            }
            if (dataInicio != null && !dataInicio.trim().isEmpty()) {
                documento.add(new Paragraph("Data de início: " + dataInicio));
            }
            if (dataTermino != null && !dataTermino.trim().isEmpty()) {
                documento.add(new Paragraph("Data de término: " + dataTermino));
            }
            
            if (descricao != null && !descricao.trim().isEmpty()) {
                documento.add(new Paragraph("\nINSTRUÇÕES ADICIONAIS:"));
                documento.add(new Paragraph(descricao));
            }
            
            documento.add(new Paragraph("\n\nOBSERVAÇÕES:"));
            documento.add(new Paragraph("• Esta receita é válida por 30 dias a partir da data de emissão"));
            documento.add(new Paragraph("• Em caso de reações adversas, suspender o uso e contactar o médico"));
            documento.add(new Paragraph("• Manter fora do alcance de crianças"));
            
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            String dataAtual = sdfData.format(new Date());
            
            documento.add(new Paragraph("\n\n\n_________________________________________________________"));
            documento.add(new Paragraph("Data: " + dataAtual));
            documento.add(new Paragraph("\n\n_________________________________________________________"));
            documento.add(new Paragraph("Assinatura do Médico"));
            
            documento.close();
            
            try {
                File pdfFile = new File(caminho);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                    return true;
                }
            } catch (Exception e) {
                System.out.println("PDF gerado em: " + caminho);
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public static boolean emitirPrescricaoSimples(String nomeMedico, String nomePaciente, 
                                                 String diagnostico, String medicamentos) {
        try {
            EmitirPrescricao prescricao = new EmitirPrescricao(
                nomeMedico, nomePaciente, diagnostico, 
                medicamentos, "", "", "", "", 
                "", "", ""
            );
            return prescricao.emitir();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}