package stepdef;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.CommonUtils;
import utils.TestBase;
import utils.TestContextSetup;

public class ebayHomegPage extends TestBase{
	public WebDriver driver;
	HomePage homePage;
	TestContextSetup testContextSetup;
	CommonUtils commonUtils;
	Properties prop;
	
	public ebayHomegPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.homePage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("^I open the browser and navigate to ebay$")
	public void i_open_the_browser_and_navigate_to_ebay() {	
		this.prop = testContextSetup.prop;
		this.commonUtils = testContextSetup.pageObjectManager.getCommonUtils();
	}
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String bookName) {
		homePage.userEntersStringInSearchBar(bookName);
			}
	@When("^I click on the first book in the search results$")
	public void i_click_on_the_first_book_in_the_search_results() {
	    homePage.clickOnFirstBook();
	}
	@When("I add the item to the cart")
	public void i_add_the_item_to_the_cart() {
	    homePage.addTocart();
	}
	@Then("the cart should display the number of items as \"([^\"]*)\"$")
	public void the_cart_should_display_the_number_of_items_as(String expectedCount) {
		System.out.println("expectedCount:"+expectedCount);
	    String actualCount=homePage.validateCartItemCount();
	    System.out.println("actualCount:"+actualCount);
	    Assert.assertEquals(expectedCount, actualCount,"Actual and Expected cart items are same");
	}
}
