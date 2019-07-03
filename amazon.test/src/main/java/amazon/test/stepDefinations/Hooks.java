package amazon.test.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import amazon.test.dataProvider.ConfigFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	private ConfigFileReader configFileReader = new ConfigFileReader();

	@Before
	public void setup() {
		DriverFactory.setDriver();
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@After
	public void teardown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		DriverFactory.getDriver().quit();
	}
}
