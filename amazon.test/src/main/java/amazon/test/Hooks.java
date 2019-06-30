package amazon.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void setup() {
		DriverFactory.setDriver("chrome");
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void teardown(Scenario scenario) {
//		if (scenario. isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
//		}
//		DriverFactory.getDriver().quit();
	}	
}
