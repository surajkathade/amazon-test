package amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

	public ProductPage() {
		WebDriver driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//a[@title='See All Buying Options']
	
	@FindBy(how=How.ID, using="buybox-see-all-buying-choices-announce")              //nav-link-yourAccount //div[@id='nav-tools']/a/span[text()='Sign in']
	private WebElement seeAllBuyingOptions;
	
	@FindBy(how=How.NAME, using="submit.addToCart")              //nav-link-yourAccount //div[@id='nav-tools']/a/span[text()='Sign in']
	private WebElement addToCart;
	
	public void clickSeeAllBuyingOptions() {
		click(seeAllBuyingOptions);
	}
	
	public void clickAddToCart() {
		click(addToCart);
	}
	
	
}
