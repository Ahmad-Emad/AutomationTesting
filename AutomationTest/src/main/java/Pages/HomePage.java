package Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Search(String searchText)
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	
}