package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ItemPage {

	WebDriver driver;

	public ItemPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement scrollIntoAddtoCartOption ()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		jse.executeScript("arguments[0].scrollIntoView(true);",(driver.findElement(By.id("add-to-cart-button"))));
		return driver.findElement(By.id("add-to-cart-button")) ;
	}

	public void AddItemToCart(WebElement AddButton)
	{
		AddButton.click();
	}
	
	public WebElement ReturnSuccessMessage()
	{
		return driver.findElement(By.xpath("//div[contains(@class,'a-section a-padding-medium sw-atc-message-section')]"));
	}
	
}
