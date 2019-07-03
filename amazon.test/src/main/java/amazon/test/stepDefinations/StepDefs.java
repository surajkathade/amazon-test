package amazon.test.stepDefinations;


import org.apache.log4j.Logger;
import org.junit.Assert;

import amazon.test.cucumber.ScenarioContext;
import amazon.test.dataProvider.ConfigFileReader;
import amazon.test.enums.Context;
import amazon.test.pages.CartPage;
import amazon.test.pages.HomePage;
import amazon.test.pages.LoginPage;
import amazon.test.pages.ProductPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDefs {
	private HomePage homepage;
	private LoginPage loginpage;
	private ProductPage productpage;
	private CartPage cartpage;
	private ScenarioContext scenarioContext;
	private ConfigFileReader configFileReader;
	static Logger logger = Logger.getLogger(StepDefs.class);
	
	public StepDefs(){
		configFileReader = new ConfigFileReader();
		homepage = new HomePage();
		loginpage = new LoginPage();
		productpage = new ProductPage();
		cartpage = new CartPage();
		scenarioContext = new ScenarioContext();
	}
	
	@Given("Open Amazon website")
	public void open_website() {
	    homepage.navigateTo(configFileReader.getApplicationUrl());
	    logger.info("User navigated to Amazon Home page");
	}

	@Given("Login to the portal")
	public void login_to_the_portal() {
		homepage.navigateToLoginPage();
		logger.info("User navigated to Amazon Login page");
		loginpage.enterEmail(configFileReader.getUserId());
		loginpage.enterPassword(configFileReader.getPassword());
		logger.info("User entered user id and password and navigated to Home page");
		
	}

	@When("Search for product {string}")
	public void search_for_product(String product) {
	    homepage.searchForProduct(product);
	    logger.info("User searched for product " + product);
	    scenarioContext.setContext(Context.PRODUCT_NAME, product);
	}

	@When("sort result by price-ascending order")
	public void sort_result_by_price_ascending_order() {
		homepage.sortBy();
		logger.info("Product list sorted in ascending order of price");
	}

	@When("add searched product to shopping cart")
	public void add_product_to_shopping_cart() {
		homepage.selectProduct((String)scenarioContext.getContext(Context.PRODUCT_NAME));
		homepage.switchToNewWindow();
		logger.info("User selected a product and navigated to product details page");
		scenarioContext.setContext(Context.PRODUCT_PRICE,productpage.getProductPrice());
		productpage.clickSeeAllBuyingOptions();
		productpage.clickAddToCart();
		logger.info("User added the product to cart");
	}

	@Then("verify product and quantity is displaying in the cart")
	public void verify_product_and_quantity_is_displaying_in_the_cart() throws InterruptedException {
	   homepage.gotoCart();
	   logger.info("User navigated to cart page");
	   Thread.sleep(3000);
	   Assert.assertEquals((String)scenarioContext.getContext(Context.PRODUCT_NAME),cartpage.getProductName().trim());
	   Assert.assertTrue("Actual Price does not match with expected", ((String)scenarioContext.getContext(Context.PRODUCT_PRICE)).contains(cartpage.getProductPrice().trim()));   
	}

	@Then("logoff")
	public void logoff() {
	    homepage.clickSignOut();
	}
}
