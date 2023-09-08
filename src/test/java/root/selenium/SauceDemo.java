package root.selenium;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {

	private WebDriver driver;

	public static void main(String[] args) {
		String file = "data.xlsx";
		String sheetName = "dataSheet";
		ExcelHandler ex = new ExcelHandler(file, sheetName);
		System.out.println(ex.getRowNum());
		System.out.println(ex.getColNum());
		System.out.println(ex.getCellDataString(1, 0));

	}

	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://www.saucedemo.com/");

	}

	@AfterMethod
	void close() throws InterruptedException {
		Thread.sleep(2000);
		this.driver.close();
	}

	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "ExternalDataSet")
	void loginTest(String username, String password, String expectedResult) throws InterruptedException {

		WebElement userName = this.driver.findElement(By.id("user-name"));
		WebElement userPassword = this.driver.findElement(By.id("password"));
		WebElement loginButton = this.driver.findElement(By.id("login-button"));

		userName.sendKeys(username);
		userPassword.sendKeys(password);
		Thread.sleep(1000);
		loginButton.click();
		Thread.sleep(1000);
		try {
			this.driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(1000);
			String logoutLink = this.driver.findElement(By.id("logout_sidebar_link")).getText();

			String actualResult = (logoutLink.compareTo("Logout") == 0) ? "Y" : "N";
			Assert.assertEquals(actualResult, expectedResult);
		} catch (NoSuchElementException e) {
			e.getMessage(); // TODO: handle exception
		}

	}

//	@DataProvider(name = "dataSet")
//	Object[][] getDataSet() {
//		Object[][] data = { { "standard_user", "secret_sauce" }, { "locked_out_user", "secret_sauce" },
//				{ "problem_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" } };
//		return data;
//	}

}
