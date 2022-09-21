package com.automationTest.pages;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResults {
	//Search_Product_Functionality
	@FindBy(xpath="//*[@id='main-search']")private WebElement ProductSearch;
	@FindBy(xpath="//*[@class='menu__search_submit']")private WebElement ProductSearchSubmit;
	
	
	//Find a Store Functionality
	@FindBy(xpath="(//*[text()='Find a store'])[1]")private WebElement Find_a_Store;
	@FindBy(xpath="(//*[@id='addressAutocomplete']")private WebElement Find_a_Store_SearchBox;
	
	
	
	
	public SearchResults(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Search_Product_Functionality(WebDriver driver)
	{
		ProductSearch.sendKeys("Jeans");
		ProductSearchSubmit.click();
		
		//Verification Of Link to validate product search is working
		
		String SearchProductURL = driver.getCurrentUrl();
		System.out.println(SearchProductURL);
		boolean Verify_Link = SearchProductURL.equalsIgnoreCase("https://www2.hm.com/en_in/search-results.html?q=jeans");
		
		Assert.assertTrue(Verify_Link);
		
	}

	public void Find_A_Store_Functionality(WebDriver driver) throws InterruptedException
	{
		
		Find_a_Store.click();
		
		Actions act=new Actions(driver);
		Find_a_Store_SearchBox.sendKeys("Pune");
		Thread.sleep(2000);
		act.sendKeys(Find_a_Store_SearchBox, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
	}
		
}
