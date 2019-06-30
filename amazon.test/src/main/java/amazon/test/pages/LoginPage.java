package amazon.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.test.stepDefinations.DriverFactory;

public class LoginPage extends BasePage{
	public LoginPage() {
		WebDriver driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	private WebElement emailField;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	@FindBy(id="ap_password")
	private WebElement passwordField;
	
	@FindBy(id="signInSubmit")
	private WebElement loginButton;
	
	public void enterEmail(String email) {
		write(emailField, email);
		click(continueButton);
	}
	
	public void enterPassword(String email) {
		write(passwordField, email);
		click(loginButton);
	}
}
