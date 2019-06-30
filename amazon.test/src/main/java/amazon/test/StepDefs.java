package amazon.test;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDefs {
	private HomePage homepage;
	private LoginPage loginpage;
	private ProductPage productpage;
	private CartPage cartpage;
	public StepDefs(){
		homepage = new HomePage();
		loginpage = new LoginPage();
		productpage = new ProductPage();
		cartpage = new CartPage();
	}
	
	@Given("Open {string} website")
	public void open_website(String url) {
	    homepage.navigateTo(url);  
	}

	@Given("Login to the portal")
	public void login_to_the_portal() {
		homepage.navigateToLoginPage();
		loginpage.enterEmail("surajkathade@gmail.com");
		loginpage.enterPassword("Prakash@1");		
	}

	@When("Search for product {string}")
	public void search_for_product(String product) {
	    homepage.searchForProduct(product);
	}

	@When("sort result by price-ascending order")
	public void sort_result_by_price_ascending_order() {
		homepage.sortBy();
	}

	@When("add product {string} to shopping cart")
	public void add_product_to_shopping_cart(String string) {
		homepage.selectProduct(string);
		homepage.switchToNewWindow();
		productpage.clickSeeAllBuyingOptions();
		productpage.clickAddToCart();
	}

	@Then("verify product and quantity is displaying in the cart")
	public void verify_product_and_quantity_is_displaying_in_the_cart() throws InterruptedException {
	   homepage.gotoCart();
	   Thread.sleep(3000);
	   Assert.assertEquals("Fossil Analog Unisex Watch - FS4656",cartpage.getProductName().trim());
	   Assert.assertEquals("10,795.00", cartpage.getProductPrice().trim());   
	}

	@Then("logoff")
	public void logoff() {
	    homepage.clickSignOut();
	}
}
