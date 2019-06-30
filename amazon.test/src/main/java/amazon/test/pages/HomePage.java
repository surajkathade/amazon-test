package amazon.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import amazon.test.stepDefinations.DriverFactory;

public class HomePage extends BasePage{
	
	public HomePage() {
		WebDriver driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	 //span[text()='Hello, Sign in']
	@FindBy(how=How.ID, using="nav-link-accountList")              
	private WebElement navLinkAccount;
	
	@FindBy(how=How.ID, using="nav-item-signout")
	private WebElement signOut;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(className="nav-input")
	private WebElement searchSubmit;
	
	@FindBy(xpath="//span[text()='Sort by:']")
	private WebElement sortByField;
	
	@FindBy(xpath="//a[text()='Price: Low to High']")
	private WebElement lowToHighOption;
	
	@FindBy(id="nav-cart")
	private WebElement navCart;
	
	public void navigateToLoginPage() {
		click(navLinkAccount);
	}
	
	public void searchForProduct(String product) {
		write(searchBox, product);
		click(searchSubmit);
	}
	
	public void selectProduct(String product) {
		WebElement productElement = DriverFactory.getDriver().findElement(By.xpath("//span[text()='"+product+"']"));
		mouseHover(productElement);
		click(productElement);
	}
	
	public void sortBy() {
		click(sortByField);
		click(lowToHighOption);
	}
	
	public void gotoCart() {
		click(navCart);
	}
	
	public void clickSignOut() {
		mouseHover(navLinkAccount);
		click(signOut);
	}
}
