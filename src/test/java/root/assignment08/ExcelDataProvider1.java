package root.assignment08;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider1 {
	public static void main(String[] args) {

		getUserFlightData();

	}

	@DataProvider(name = "ExternalDataSet1")
	public static Object[][] getUserFlightData() {
		String file = "FlightSearch.xlsx";
		String sheetName = "FlightDataSheet";
		ExcelHandler1 ex = new ExcelHandler1(file, sheetName);
		int row = ex.getRowNum();
		int col = ex.getColNum();

		Object[][] data = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = ex.getCellDataString(i, j);
				System.out.print(ex.getCellDataString(i, j) + " ");
			}
//			System.out.println();
		}
		return data;

	}
}
