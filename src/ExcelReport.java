import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReport {

	private CellStyle cs = null;
	private CellStyle csBold = null;

	public void createExcel() {

		try {

			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("NOME DA PLANILHA");
			setCellStyles(wb);

			sheet.setColumnWidth(0, 4000);
			sheet.setColumnWidth(1, 12000);
			sheet.setColumnWidth(2, 5000);
			sheet.setColumnWidth(3, 5000);

			sheet.setMargin(Sheet.LeftMargin, 0.25);
			sheet.setMargin(Sheet.RightMargin, 0.25);
			sheet.setMargin(Sheet.TopMargin, 0.75);
			sheet.setMargin(Sheet.BottomMargin, 0.75);

			int rowIndex = 0;
			
			rowIndex = insertHeaderInfo(sheet, rowIndex);
			rowIndex = insertDetailInfo(sheet, rowIndex);

			rowIndex = rowIndex++ * 1;
			rowIndex = insertHeaderInfo(sheet, rowIndex);
			rowIndex = insertDetailInfo(sheet, rowIndex);

			FileOutputStream fileOut = null;
			fileOut = new FileOutputStream("C:/Desenvolvimento/Excel/myReport.xlsx");
			wb.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			System.out.println(e);
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
