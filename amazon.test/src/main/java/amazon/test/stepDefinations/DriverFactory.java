package amazon.test.stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;

	public static void setDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "C:\\Workdir\\amazon.test\\Lib\\chromedriver.exe");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
}
