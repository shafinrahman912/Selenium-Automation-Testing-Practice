package root.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import root.common.BrowserHandler;

public class AlertTest extends BrowserHandler {

	@BeforeMethod
	void setURL() {
		this.driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@Test
	void alertTest() throws InterruptedException {

//		Normal Alert
		WebElement alertBtn = this.driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
		alertBtn.click();

		Alert alert = this.driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		if (this.driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("You Pressed Ok Button");

		}

//		Confirmation Alert	
		WebElement alertBtn1 = this.driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
		alertBtn1.click();

		Alert alert1 = this.driver.switchTo().alert();
		System.out.println("\nAlert for confirmation: \n" + alert1.getText());
		Thread.sleep(2000);
		alert1.dismiss();
		Thread.sleep(2000);
		if (this.driver.getPageSource().contains("You clicked: Ok")) {
			System.out.println("You Pressed Ok Button");

		} else {
			System.out.println("You Pressed Cancel Button");
		}

//		Promt Alert
		WebElement alertBtn2 = this.driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
		alertBtn2.click();

		Alert alert2 = this.driver.switchTo().alert();
		System.out.println("\nAlert for promt: \n" + alert2.getText());
		Thread.sleep(2000);
		alert2.sendKeys("ostad");
		alert2.accept();
		Thread.sleep(2000);
		if (this.driver.getPageSource().contains("You entered: ostad")) {
			System.out.println("You entered: ostad");

		} else {
			System.out.println("You Entered Null");
		}

	}

	// This below code is according to the assignment question demonstration.
	// Which is "Write a code snippet in Selenium WebDriver using Java to click a
	// "Submit" button and handle the alert that appears. Assume the button has an
	// ID "submitButton"."

//	@Test
	void alertTestSubmitButton() throws InterruptedException {

		this.driver.get("Enter example website url which contains Submit button with id 'submitButton' ");

//		Submit Button Alert	
		WebElement submitAlertBtn = this.driver.findElement(By.id("submitButton"));
		submitAlertBtn.click();

		Alert submitAlert = this.driver.switchTo().alert();
		System.out.println("\nAlert for confirmation: \n" + submitAlert.getText());
		Thread.sleep(2000);
		submitAlert.accept();
		Thread.sleep(2000);
		if (this.driver.getPageSource().contains("You clicked: submit")) {
			System.out.println("You Pressed Submit Button");

		} else {
			System.out.println("You Pressed Cancel Button");
		}
	}
}
