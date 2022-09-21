package com.automationTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Shopping_Category_Page {
	
	//Women-->Dresses
	@FindBy(xpath="(//*[text()='Ladies'])[1]")private WebElement Women;
	@FindBy(xpath="(//*[text()='Dresses'])[1]")private WebElement Women_Dresses;
	@FindBy(xpath="//*[@class='heading ']")private WebElement Dresses_Heading;
	
	//Men-->New Arrival-->Sports wear
	@FindBy(xpath="(//a[@data-tracking-label='men'])[1]")private WebElement Men;
	@FindBy(xpath="(//a[@data-tracking-label='blazers-and-suits'])[1]")private WebElement men_Suits_and_Blazers;
	@FindBy(xpath="//*[@class='heading ']")private WebElement Sportwear_Heading;
	
	//Baby-->Newborn-->Clothing
	@FindBy(xpath="(//span[text()='Baby'])[1]")private WebElement Baby;
	@FindBy(xpath="(//a[@data-tracking-label='clothing'])[1]")private WebElement Baby_Clothing;
	@FindBy(xpath="//*[@class='heading ']")private WebElement Clothing_Heading;
	
	//Sports-->Men-->Accessories & Equipment
	@FindBy(xpath="(//span[text()='Sport'])[1]")private WebElement Sports;
	@FindBy(xpath="(//*[text()='Accessories & Equipment'])[2]")private WebElement Accessories_and_Equipment;
	@FindBy(xpath="//*[@class='heading ']")private WebElement MENS_SPORT_ACCESSORIES;
	
	
	public Shopping_Category_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void shop_by_product_functionality_for_Ladies_Category(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(Women).perform();
		Women_Dresses.click();
		
		//Assertion
		//First Assertion- Verification that user is redirected to https://www2.hm.com/en_in/women/shop-by-product/dresses.html
		String women_Dresses_URL = driver.getCurrentUrl();
		System.out.println(women_Dresses_URL);
		
		Assert.assertEquals(women_Dresses_URL, "https://www2.hm.com/en_in/women/shop-by-product/dresses.html");
		
		//Second Assertion-Verification of page header
		String DressesHeading = Dresses_Heading.getText();
		System.out.println(DressesHeading);
		Assert.assertEquals(DressesHeading, "DRESSES");
	}
	
	public void shop_by_product_functionality_for_Men_Category(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(Men).perform();
		men_Suits_and_Blazers.click();
		
		//Assertion
		//First Assertion-Verification that user is redirected to https://www2.hm.com/en_in/men/shop-by-product/suits-blazers.html
		String men_SuitsandBlazer_URL = driver.getCurrentUrl();
		System.out.println(men_SuitsandBlazer_URL);
		
		Assert.assertEquals(men_SuitsandBlazer_URL, "https://www2.hm.com/en_in/men/shop-by-product/suits-blazers.html");
		
		//Second Assertion-Verification of page header
		String SuitsandBlazerHeading = Sportwear_Heading.getText();
		System.out.println(SuitsandBlazerHeading);
		
		Assert.assertEquals(SuitsandBlazerHeading, "MEN'S SUITS & BLAZERS");
	}

	public void shop_by_product_functionality_for_Baby_Category(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(Baby).perform();
		Baby_Clothing.click();
		
		//Assertion
	    //First Assertion-Verification that user is redirected to https://www2.hm.com/en_in/baby/newborn/clothing.html
		String Baby_Clothing_URL = driver.getCurrentUrl();
		System.out.println(Baby_Clothing_URL);
		Assert.assertEquals(Baby_Clothing_URL, "https://www2.hm.com/en_in/baby/newborn/clothing.html");
		
		//Second Assertion-Verification of page header
		String BabyClothingHeading = Clothing_Heading.getText();
		System.out.println(BabyClothingHeading);
		Assert.assertEquals(BabyClothingHeading, "NEWBORN BABY CLOTHES");
	}
	
	public void shop_by_product_functionality_for_Sports_Category(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(Sports).perform();
		Accessories_and_Equipment.click();
		
		//Assertion
	    //First Assertion-Verification that user is redirected to https:https://www2.hm.com/en_in/sport/men/sports-accessories.html
		String MensSportswear = driver.getCurrentUrl();
		System.out.println(MensSportswear);
		
		//Second Assertion-Verification of page header
		String Suits_And_Blazers = MENS_SPORT_ACCESSORIES.getText();
		System.out.println(Suits_And_Blazers);
		Assert.assertEquals(Suits_And_Blazers, "MEN'S SPORT ACCESSORIES");
		
		
	}
}
