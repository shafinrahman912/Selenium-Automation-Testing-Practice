package root.listen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;
import root.screenshot.ScreenshotDemo;

public class CustomListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess: " + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure: " + result.getName());
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		
	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileUtils.copyFile(screenshotFile,
					new File("D:\\SHAFIN_personal\\Ostad\\Java\\MavenProject01\\Screenshot\\abcd.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot Captured");
		
		driver.quit();
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped: " + result.getName());
	}
	
	public void onStart(ITestContext context) {
		System.out.println("onStart: " + context.getName());
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("onFinish: " + context.getName());
	}
	

}
