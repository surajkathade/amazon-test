package amazon.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import amazon.test.stepDefinations.DriverFactory;

public class ProductPage extends BasePage{

	public ProductPage() {
		WebDriver driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//a[@title='See All Buying Options']
	
	
	@FindBy(how=How.XPATH, using="//div[@id='unqualifiedBuyBox']//span[@class='a-color-price']")
	private WebElement productPrice;
	
	@FindBy(how=How.ID, using="buybox-see-all-buying-choices-announce")
	private WebElement seeAllBuyingOptions;
	
	@FindBy(how=How.NAME, using="submit.addToCart")
	private WebElement addToCart;
	
	public void clickSeeAllBuyingOptions() {
		click(seeAllBuyingOptions);
	}
	
	public void clickAddToCart() {
		click(addToCart);
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
}
