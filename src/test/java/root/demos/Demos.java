package root.demos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import root.common.BrowserHandler;

public class Demos extends BrowserHandler {

//	@BeforeMethod
//	void setURL() {
//		this.driver.get("https://trytestingthis.netlify.app/");
//	}

	@Test
	void dropDown() throws InterruptedException {
		WebElement dropDown = this.driver.findElement(By.id("option"));

		Select selectObject = new Select(dropDown);
		selectObject.selectByIndex(3);
		Thread.sleep(3000);
		selectObject.selectByValue("option 1");
		Thread.sleep(3000);
		selectObject.selectByVisibleText("Option 2");
		Thread.sleep(3000);

	}

	@Test
	void selectmultiple() throws InterruptedException {
		WebElement multiSelect = this.driver.findElement(By.id("owc"));

		Select selectMultiObject = new Select(multiSelect);

		selectMultiObject.selectByIndex(1);
		Thread.sleep(3000);
		selectMultiObject.selectByValue("option 3");
		Thread.sleep(3000);
		selectMultiObject.selectByVisibleText("Option 2");
		Thread.sleep(3000);
		selectMultiObject.deselectByIndex(1);

	}

	@Test
	void alertTest() throws InterruptedException {

		this.driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement alertBtn = this.driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
		alertBtn.click();

		Alert alert = this.driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();

		Thread.sleep(2000);
		
		if(this.driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("You Pressed Ok Button");
			
		}

		WebElement alertBtn1 = this.driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));

		alertBtn1.click();

		Alert alert1 = this.driver.switchTo().alert();
		System.out.println(alert1.getText());
		Thread.sleep(2000);
		alert1.dismiss();
		Thread.sleep(2000);

		WebElement alertBtn2 = this.driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
		alertBtn2.click();

		Alert alert2 = this.driver.switchTo().alert();
		System.out.println(alert2.getText());
		Thread.sleep(2000);
		alert2.sendKeys("ostad");
		alert2.accept();
		Thread.sleep(2000);

	}
}
