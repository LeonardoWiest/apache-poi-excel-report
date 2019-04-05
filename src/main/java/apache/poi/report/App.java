package apache.poi.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import apache.poi.report.dto.ProdutoDTO;

public class App {

	private static String[] colunasNovaGrade = { "C�DIGO", "DESCRI��O", "GTIN", "UNIDADE", "QTDE. EMB.", "VALOR",
			"VALOR DISP.", "QTDE. M�N.", "QTDE MAX,", "QTDE. M�LT.", "PREFIXO" };

	private static List<ProdutoDTO> listaProdutosNovaGrade = new ArrayList<ProdutoDTO>();

	public static void main(String[] args) throws IOException {

		reportGradeCriada();

	}

	private static void reportGradeCriada() throws IOException {

		listaProdutosNovaGrade.add(new ProdutoDTO(1L, "COCA-COLA", 12345678912345L, "UN", 5L, new BigDecimal("2.90"),
				new BigDecimal("2.90"), 10L, 40L, 2L, "CARNAVAL"));

		Workbook workbook = new XSSFWorkbook();
		// DESCRI��O DA PLANILHA
		Sheet sheet = workbook.createSheet("Grade 1");

		// CRIA��O DO CABE�ALHO
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// CRIA��O DAS COLUNAS
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < colunasNovaGrade.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasNovaGrade[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// CRIA LINHAS E AS ALIMENTA COM O CONTE�DO
		int rowNum = 1;

		for (ProdutoDTO produto : listaProdutosNovaGrade) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(produto.id);
			row.createCell(1).setCellValue(produto.descricao);
			row.createCell(2).setCellValue(produto.gtin);
			row.createCell(3).setCellValue(produto.unidadeMedida);
			row.createCell(4).setCellValue(produto.qtdeEmbalagem);
			row.createCell(5).setCellValue(produto.valor.toString());
			row.createCell(6).setCellValue(produto.valorDisponivel.toString());
			row.createCell(7).setCellValue(produto.qtdeMinima);
			row.createCell(8).setCellValue(produto.qtdeMaxima);
			row.createCell(9).setCellValue(produto.qtdeMultipla);
			row.createCell(10).setCellValue(produto.prefixo);
		}

		// REDIMENCIONA A LARGURA DAS COLUNAS
		for (int i = 0; i < colunasNovaGrade.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// REALIZA A SA�DA DO ARQUIVO
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("C:/Desenvolvimento/Git/src/main/resources/reports/grade1.xlsx");
			workbook.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
