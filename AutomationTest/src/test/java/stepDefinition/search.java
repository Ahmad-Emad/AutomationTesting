package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.ItemPage;
import Pages.SearchResults;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import static org.junit.Assert.*;

public class search {

	WebDriver driver;
	@Before
    public void beforeScenario(){
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://www.amazon.com/");
    	driver.manage().window().maximize();
    }	
	@After
    public void afterScenario(){
    	driver.close();
    	driver.quit();
    }	

@Given("I search on Amazon with {string}")
public void i_have_a_search_on_amazon(String searchText) {
	HomePage home = new HomePage(driver);	
	home.Search(searchText);	
}

@When("I select search number {int}")
public void i_select_first_result(int searchNumber) {
	SearchResults search = new SearchResults(driver);
	search.openSearchResult(searchNumber);
	}

@Then("Verify Add to cart option is enabled")
public void AddtoCart_is_enabled() {
		ItemPage item = new ItemPage(driver);
		WebElement addToCartButton = item.scrollIntoAddtoCartOption();
		assertTrue(addToCartButton.isEnabled());
	}

@When("I Add item to cart")
public void i_add_item_to_cart() {
	ItemPage item = new ItemPage(driver);
	WebElement addToCartButton = item.scrollIntoAddtoCartOption();
	item.AddItemToCart(addToCartButton);
}

@Then("Verify Item added to cart successfully")
public void verify_item_added_to_cart_successfully() {
	ItemPage item = new ItemPage(driver);
	WebElement returnedMessage = item.ReturnSuccessMessage();
	String Message = "Added to Cart";
	assertEquals(Message, returnedMessage.getText());
}

}
