package root.selenium;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	public static void main(String[] args) {
//		String file = "data.xlsx";
//		String sheetName = "dataSheet";
//		ExcelHandler ex = new ExcelHandler(file, sheetName);
//		System.out.println(ex.getRowNum());
//		System.out.println(ex.getColNum());
//		System.out.println(ex.getCellDataString(1, 0));
		getUserData();

	}

	@DataProvider(name = "ExternalDataSet")
	public static Object[][] getUserData() {
		String file = "data.xlsx";
		String sheetName = "dataSheet";
		ExcelHandler ex = new ExcelHandler(file, sheetName);
		int row = ex.getRowNum();
		int col = ex.getColNum();

		Object[][] data = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = ex.getCellDataString(i, j);
//				System.out.print(ex.getCellDataString(i, j) + " ");
			}
//			System.out.println();
		}
		return data;

	}
}
