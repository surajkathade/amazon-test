package amazon.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class CartPage {

	public CartPage() {
		WebDriver driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//a-row sc-list-item sc-list-item-border sc-java-remote-feature
	@FindBy(how=How.CLASS_NAME, using="a-row sc-list-item sc-list-item-border sc-java-remote-feature")
	private WebElement item;
	
	@FindBy(how=How.XPATH, using="//span[@class='a-size-medium sc-product-title a-text-bold']")
	private WebElement productName;
	
	@FindBy(how=How.XPATH, using="//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']")
	private WebElement productPrice;
	
//	Fossil Analog Unisex Watch - FS4656
	public String getProductName() {
		return productName.getText();
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
}
