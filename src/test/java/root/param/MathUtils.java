package root.param;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MathUtils {

	@Test
	@Parameters({ "num1", "num2" })
	public void addition(int a, int b) {
		int result = a + b;
		System.out.println("Addition: " + result);

	}

	@Test(dataProvider = "dataSet")
	public void subtract(int a, int b) {
		int result = a - b;
		System.out.println("Subtraction: " + result);

	}
	@DataProvider(name="dataSet")
	Object[][] getDataSet(){
		Object data[][]= {{10,5},{20,10}};
		return data;
		
	}
}
