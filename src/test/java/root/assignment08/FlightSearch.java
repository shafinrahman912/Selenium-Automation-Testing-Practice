package root.assignment08;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class FlightSearch {
	private WebDriver driver;

	
	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://www.esky.com/flights?gad=1&gclid=EAIaIQobChMIyM3x0sThgAMVdYNLBR1zxQkSEAMYASAAEgKFSvD_BwE");

	}

	@AfterMethod
	void close() throws InterruptedException {
		Thread.sleep(2000);
		this.driver.close();
	}

	@Test(dataProviderClass = ExcelDataProvider1.class, dataProvider = "ExternalDataSet1")
	void flightSearch(String origin, String destination) throws InterruptedException {

		WebElement originInput = this.driver.findElement(By.name("tr[0][d]"));
		WebElement destinationInput = this.driver.findElement(By.name("tr[0][a]"));
		
		
		this.driver.findElement(By.name("tr[0][dd]")).click();
		Thread.sleep(1000);
		
//		this.driver.findElement(By.cssSelector("calendar-day ng-star-inserted disabled is-one-day-selection")).click();
		WebElement searchButton = this.driver.findElement(By.className("qsf-search"));
		Thread.sleep(1000);
		originInput.sendKeys(origin);
		Thread.sleep(1000);
		destinationInput.sendKeys(destination);
		Thread.sleep(1000);
//		departureDateInput.sendKeys(departureDate);
//		Thread.sleep(1000);
		searchButton.click();
		Thread.sleep(1000);

	}

}
