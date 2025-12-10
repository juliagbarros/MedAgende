package Back;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Agenda {
    public static void recebeplanilha(File arquivo) {
    	//System.out.println("[DEBUG]recebeplanilha chamado");
    	

        try (FileInputStream fis = new FileInputStream(arquivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet pagina = workbook.getSheetAt(0); //Seleciona a primeira página da planilha
            Iterator<Row> ItLinha = pagina.iterator();
            
            //só uma String que vai retornar as informações no terminal
            String resultado;
            resultado = "Conteúdo lido:";
            
            //Criando a variável ponte para o LocalDateTime
            LocalDateTime dt;
            
            try {
            	//System.out.println("[DEBUG] acessando as linhas da planilha");
            	
            	//Esses Whiles servem para o código passar por todas as linhas e colunas da planilha
				while (ItLinha.hasNext()) {
					Row linha = ItLinha.next();
					//Os Iterators também servem para a mesma finalidade
					Iterator<Cell> ItColuna = linha.cellIterator();
					while (ItColuna.hasNext()){
						Cell celula = ItColuna.next();
						if (celula.getCellType() == CellType.STRING) break; //Um pequeno tratamento de dados para ignorar as células que apresentarem texto
						
						//O ponto desse swtich é que ele funciona com o index da coluna, então a planilha DEVE ter a primeira coluna sendo a data, e as outras duas sendo horário de entrada/saida
						switch (celula.getColumnIndex()) {
						case 0:
							//como dito, DT é a variável ponte e por isso é constantemente sobrescrita
							dt = celula.getLocalDateTimeCellValue();
							//Concatenando o texto para no final ter um diálogo completo no terminal, para adicionar no BD seria bom mante-los separados e no final juntar em um código SQL
							resultado += ("Data: " + dt.toLocalDate().toString() + "; ");
							break;
						case 1:
							dt = celula.getLocalDateTimeCellValue();
							
							resultado += ("Horário de Entrada: " + dt.toLocalTime().toString() + "; ");
							break;
						case 2:
							 dt = celula.getLocalDateTimeCellValue();
							
							resultado += ("Horário de Saída: " + dt.toLocalTime().toString() + "; ");
							break;
						default:
							break;
						}
					}
				//por fim printando o resultado
				System.out.println(resultado);
				resultado = "\n";
				}
			} catch (Exception eprintacelula) {
				
				System.out.println("Erro ao printar célula, código do erro: " + eprintacelula);
			}

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

