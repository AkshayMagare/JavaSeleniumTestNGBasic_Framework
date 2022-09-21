package com.automationTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HM_Home_Page {
	
	@FindBy(xpath="(//a[@data-tracking-label='men'])[1]")private WebElement Men;
	@FindBy(xpath="(//a[text()='Shirts'])[1]")private WebElement Shirts;
	@FindBy(xpath="(//a[@title='Patterned resort shirt'])[1]")private WebElement Patternedresort;
	@FindBy(xpath="(//button[@type='button'])[24]")private WebElement favourite;
	@FindBy(xpath="//a[@class='menu__favorites']")private WebElement favouriteBtn;
	@FindBy(xpath="//a[text()='Patterned resort shirt']")private WebElement favourites;
	
	public HM_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Select_Men_Category(WebDriver driver) throws InterruptedException
	{	
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveToElement(Men).perform();
		Thread.sleep(3000);
		Shirts.click();
	}
	public void Add_To_Favourite(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Patternedresort.click();

		Thread.sleep(2000);
		favourite.click();	
	}
	public void Verification_of_Product_added_In_Favourites(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		favouriteBtn.click();
		
		String actfavo = favourites.getText();
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
	

}

	
}
