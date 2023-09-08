package root.dragndrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import root.common.BrowserHandler;

public class DragNDropDemo extends BrowserHandler {

	@BeforeMethod
	void setURL() {
		this.driver.get("https://jqueryui.com/droppable/");
	}

	@Test
	void dragNdrop() throws InterruptedException {

		WebElement frame = this.driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		this.driver.switchTo().frame(frame);

		WebElement sourceElement = this.driver.findElement(By.id("draggable"));
		WebElement targetElement = this.driver.findElement(By.id("droppable"));

		Actions act = new Actions(this.driver);
		Thread.sleep(2000);
		act.dragAndDrop(sourceElement, targetElement).perform();
		Thread.sleep(2000);

	}
}
