package amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;

	public static synchronized void setDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "C:\\Workdir\\amazon.test\\Lib\\chromedriver.exe");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
	}
	
	public static synchronized WebDriver getDriver() {
		return driver;
	}
	
	
}
