package amazon.test.stepDefinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import amazon.test.dataProvider.ConfigFileReader;

public class DriverFactory {

	private static WebDriver driver;
	private static ConfigFileReader configFileReader = new ConfigFileReader();
	static Logger logger = Logger.getLogger(DriverFactory.class);

	public static synchronized void setDriver() {
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		if(configFileReader.getBrowser().equals("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			throw new RuntimeException("browser not specified correctly in the config.properties file.");
		}
	}
	
	public static synchronized WebDriver getDriver() {
		return driver;
	}
}
