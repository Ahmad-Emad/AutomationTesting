package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class SearchResults {
	
	WebDriver driver;

	public SearchResults(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void openSearchResult(int Number)
	{

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> searchResults = driver.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));	
		searchResults.get(Number-1).click();
	
		
	}
}
