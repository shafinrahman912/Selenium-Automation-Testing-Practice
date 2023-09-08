package root.selenium;

import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumIntro {
	WebDriver driver;

	@BeforeMethod
	void setup() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void test1() {
		// TODO Auto-generated method stub

//		driver = new ChromeDriver();
		driver.get("https:google.com");
//		driver.findElement(By.name("q")).sendKeys("ostad");
//		WebElement searchText=driver.findElement(By.name("q"));
//		searchText.sendKeys("ostad"+Keys.ENTER);
		driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/&ogbl']")).click();
		driver.quit();
	}

	@Test
	void loginTest() throws InterruptedException {
//		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));


		
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();
//		Thread.sleep(5000);
//		driver.quit();
	}

}
