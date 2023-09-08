package root.selenium;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelHandler(String file, String sheetName) {

		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sheet = workbook.getSheet(sheetName);
	}

	public int getRowNum() {
		return this.sheet.getPhysicalNumberOfRows();
	}

	public int getColNum() {
		return this.sheet.getRow(0).getPhysicalNumberOfCells();
	}

	public String getCellDataString(int row, int col) {
		return this.sheet.getRow(row).getCell(col).getStringCellValue();
	}

}
