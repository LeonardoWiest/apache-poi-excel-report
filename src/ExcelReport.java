import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import apache.poi.converter.Converter;
import apache.poi.dto.GradeDTO;
import apache.poi.dto.ProdutoDTO;

public class ExcelReport {

	private CellStyle cs = null;
	private CellStyle csBold = null;

	public void createExcel() {

		try {

			List<GradeDTO> listaGrades = new ArrayList<>();

			List<ProdutoDTO> listaProdutos = new ArrayList<>();

			ProdutoDTO produtoDTO1 = new ProdutoDTO();
			produtoDTO1.setId(1L);
			produtoDTO1.setDescricao("Produto 1");
			produtoDTO1.setGtin(231231231231L);
			produtoDTO1.setPreco(new BigDecimal("3123"));

			listaProdutos.add(produtoDTO1);

			GradeDTO gradeDTO1 = new GradeDTO();
			gradeDTO1.setId(1L);
			gradeDTO1.setDescricao("Grade 1");
			gradeDTO1.setDataInicio(new Date());
			gradeDTO1.setDataInicio(new Date());
			gradeDTO1.setProdutoDTO(listaProdutos);

			listaGrades.add(gradeDTO1);

			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("NOME DA PLANILHA");
			setCellStyles(wb);

			criarColunas(listaGrades, sheet);

			/*
			 * sheet.setColumnWidth(0, 4000); sheet.setColumnWidth(1, 12000);
			 * sheet.setColumnWidth(2, 5000); sheet.setColumnWidth(3, 5000);
			 * 
			 * sheet.setMargin(Sheet.LeftMargin, 0.25);
			 * sheet.setMargin(Sheet.RightMargin, 0.25);
			 * sheet.setMargin(Sheet.TopMargin, 0.75);
			 * sheet.setMargin(Sheet.BottomMargin, 0.75);
			 */

			/*
			 * int rowIndex = 0;
			 * 
			 * rowIndex = insertHeaderInfo(sheet, rowIndex); rowIndex =
			 * insertDetailInfo(sheet, rowIndex);
			 * 
			 * rowIndex = rowIndex + 1; rowIndex = insertHeaderInfo(sheet,
			 * rowIndex); rowIndex = insertDetailInfo(sheet, rowIndex);
			 */

			FileOutputStream fileOut = null;
			fileOut = new FileOutputStream("C:/Desenvolvimento/Excel/myReport.xlsx");
			wb.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	private void criarColunas(List<?> lista, Sheet sheet) {

		Field[] listaColunas = Converter.getAllFields(lista.get(0).getClass());

		int rowIndex = 0;
		Row row = null;
		Cell c = null;

		row = sheet.createRow(rowIndex);

		for (Field field : listaColunas) {
			apache.poi.annotation.ExcelReport dtoReport = field
					.getDeclaredAnnotation(apache.poi.annotation.ExcelReport.class);

			c = row.createCell(rowIndex++);
			c.setCellValue(dtoReport.descricaoColuna());
			c.setCellStyle(csBold);

		}

	}

	private void setCellStyles(Workbook wb) {

		Font f = wb.createFont();
		f.setFontHeightInPoints((short) 10);

		Font bold = wb.createFont();
		bold.setFontHeightInPoints((short) 10);

		csBold = wb.createCellStyle();
		csBold.setBorderBottom(BorderStyle.THIN);
		csBold.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		csBold.setFont(bold);
	}

	private int insertHeaderInfo(Sheet sheet, int index) {

		int rowIndex = index;
		Row row = null;
		Cell c = null;

		rowIndex++;
		row = sheet.createRow(rowIndex);

		c = row.createCell(0);
		c.setCellValue("CÓDIGO GRADE");
		c.setCellStyle(csBold);

		c = row.createCell(1);
		c.setCellValue("DESCRIÇÃO");
		c.setCellStyle(csBold);

		c = row.createCell(2);
		c.setCellValue("DATA INÍCIO");
		c.setCellStyle(csBold);

		c = row.createCell(3);
		c.setCellValue("DATA FIM");
		c.setCellStyle(csBold);

		return rowIndex;

	}

	private int insertDetailInfo(Sheet sheet, int index) {

		int rowIndex = 0;

		Row row = null;

		Cell c = null;

		for (int i = 1; i < 5; i++) {

			rowIndex = index + i;
			row = sheet.createRow(rowIndex);

			c = row.createCell(0);
			c.setCellValue(i);
			c.setCellStyle(cs);

			c = row.createCell(1);
			c.setCellValue("GRADE DE TESTE " + i);
			c.setCellStyle(cs);

			c = row.createCell(2);
			c.setCellValue("10/03/2019 14:00");
			c.setCellStyle(cs);

			c = row.createCell(3);
			c.setCellValue("14/03/2019 19:00");
			c.setCellStyle(cs);

		}

		return rowIndex;

	}

}
