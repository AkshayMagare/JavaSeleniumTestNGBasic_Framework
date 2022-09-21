package com.automationTest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HM_FavouritePage 
{
	String actfavo;
	boolean ShirtAvailable;
	
	@FindBy(xpath="//a[text()='Patterned resort shirt']")private WebElement Patterned_resort_shirt;;
	@FindBy(xpath="(//*[@class='innerElement'])[1]")private WebElement favourite;
	@FindBy(xpath="//a[@class='menu__favorites']")private WebElement favouriteBtn;
	@FindBy(xpath="(//*[text()='Patterned resort shirt'])[1]")private WebElement shirtName;
	@FindBy(xpath="(//button[@type='button'])[4]")private WebElement removeFavourite;
	
	public HM_FavouritePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPatternedresortHM_MenShirtsPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Patterned_resort_shirt.click();

		Thread.sleep(2000);
		favourite.click();	
	}
	

	public void clickHM_FavouritePageBtn(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		favouriteBtn.click();
		
		Thread.sleep(5000);
		String actfavo = shirtName.getText();
		//System.out.println(acttext);
		String exptfavo="Patterned resort shirt";
		if(actfavo.equals(exptfavo))
		{
			System.out.println("Shirt added in favourites");
		}
		else
		{
			System.out.println("Shirt not added in favourites");
		}
		
		ShirtAvailable = shirtName.isDisplayed();
		Assert.assertTrue(ShirtAvailable);
		
		
		
	}
	
	public void Remove_product_from_Favourites(WebDriver driver) 
	{
		//removeFavourite.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", removeFavourite);
		
//		boolean ShirtAvailable = shirtName.isDisplayed();
//		//Assert.assertFalse(ShirtAvailable);
//		System.out.println(ShirtAvailable);
		
		Assert.assertFalse(ShirtAvailable, "Failed: Product is not removed from Favourites");
		
		
		
		
	}
	
	
}
