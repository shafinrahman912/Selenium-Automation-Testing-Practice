package root.screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {

	private WebDriver driver;
	
	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://www.saucedemo.com/");

	}
	@AfterMethod
	void close() {
		this.driver.quit();
	}
	@Test
	void screenShot() throws IOException, InterruptedException {
		Date currentDate=new Date();
//		System.out.println(currentDate.toString());
		String screenshotFileName=currentDate.toString().replace(":", "-").replace(" ", "-");
		System.out.println(screenshotFileName);
		
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(1000);
		FileUtils.copyFile(screenshotFile, new File("D:\\SHAFIN_personal\\Ostad\\Java\\MavenProject01\\Screenshot\\"+screenshotFileName+".png"));
		System.out.println("Screenshot Captured");
	}
}
