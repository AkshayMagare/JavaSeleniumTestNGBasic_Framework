package com.automationTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Redirection_of_HM_LOGO {
	
	@FindBy(xpath= "//*[@class='menu__hm']") WebElement HMLOGO;
	@FindBy(xpath="//a[@class='menu__favorites']")private WebElement favouriteBtn;
	
	
	public Redirection_of_HM_LOGO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Redirect_To_Favourites() 
	{
		favouriteBtn.click();
	}
	
	
	public void RedirectionHMLogo(WebDriver driver) 
	{
		HMLOGO.click();
		String HMLogoLink = driver.getCurrentUrl();
		System.out.println(HMLogoLink);
		boolean VerificationofHMLogoRedirection = HMLogoLink.equalsIgnoreCase("https://www2.hm.com/en_in/index.html");
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(VerificationofHMLogoRedirection, true);
		sa.assertAll();
		
	}
	

}
