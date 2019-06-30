package amazon.test.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import amazon.test.stepDefinations.DriverFactory;

public class BasePage {

	public void navigateTo(String url) {
		DriverFactory.getDriver().get(url);
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(DriverFactory.getDriver());
		action.moveToElement(element).perform();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void write(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void switchToNewWindow() {
		String parentWindow = DriverFactory.getDriver().getWindowHandle();
		Set<String> handles =  DriverFactory.getDriver().getWindowHandles();
		   for(String windowHandle  : handles){
		       	if(!windowHandle.equals(parentWindow)){
		       		DriverFactory.getDriver().switchTo().window(windowHandle);
		       }
		   }
	}
}
