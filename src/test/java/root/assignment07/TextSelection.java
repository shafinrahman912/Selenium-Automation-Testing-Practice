package root.assignment07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextSelection {
	private WebDriver driver;

	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://ostad.app/en");
	}

	@AfterMethod
	void close() throws InterruptedException {
		Thread.sleep(1000);
		this.driver.close();
	}

	@Test
	void testOne() {

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Learn skills ')]"));

		String selectedText = element.getText();

		System.out.println("Selected Text: " + selectedText);

	}

	@Test
	void testTwo() {

//		WebDriver driver = new ChromeDriver();
//		driver.get("https://ostad.app/en");
		driver.findElement(By.className("text_black ")).sendKeys(Keys.CONTROL, "a"); // Select all text


	}

}
