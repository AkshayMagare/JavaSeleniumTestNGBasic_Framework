package com.automationTest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Sign_up_newsletter {
	//Click on Sign up
	@FindBy(xpath= "//*[text()='Sign up']") WebElement SignUP;
	
	//Data Filling
	@FindBy(xpath= "//*[@id='txt-email']") WebElement EmailFilling;
	@FindBy(xpath= "//*[@id='newsletter-i-am-gender-male']") WebElement Male_Gender;
	@FindBy(xpath= "//*[@name='newsletter-i-am-kids']") WebElement UpdatesForKids;
	@FindBy(xpath= "//*[@name='postalCode']") WebElement PostalCode;
	@FindBy(xpath= "//*[@id='cs-fashion-news']") WebElement PrivacyNoticeAgreement;
	//@FindBy(xpath= "(//*[@class='button'])[1]") WebElement SIGNUP;
	//@FindBy(xpath= "//div[@class='newsletter-thankyou-form']/input[@value='Yes, sign me up!']") WebElement SIGNUP;
	@FindBy(xpath= "//input[@class = 'button' and contains(@value,  'sign me up')]") WebElement SIGNUP;
	
	//After sign up Verification
	@FindBy(xpath= "//*[@class='page-header']") WebElement PageHeader;
	
	
	public Sign_up_newsletter(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void redirectToSignUpPage()
	{
		SignUP.click();			
	}
	
	public void Sign_Up_for_Newsletter(WebDriver driver) throws InterruptedException
	{
		EmailFilling.sendKeys("magareakshay445@gmail.com");
		Male_Gender.click();
		UpdatesForKids.click();
		PostalCode.sendKeys("415519");
		PrivacyNoticeAgreement.click();
		WebDriverWait wait= new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(SIGNUP));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", SIGNUP);
		//js.executeScript("arguments[0].click();",SIGNUP);
		
		Thread.sleep(5000);
		SIGNUP.click();
		SIGNUP.click();
		SIGNUP.click();
		SIGNUP.click();
		SIGNUP.click();
		
		//Actions act=new Actions(driver);
		//act.click(SIGNUP).perform();

		//boolean DisableSignUpButton = SIGNUP.isEnabled();
		
		/*if(DisableSignUpButton==false)
		{
			wait.until(ExpectedConditions.elementToBeClickable(SIGNUP));
			SIGNUP.click();
		}
		else
		{
			System.out.println("SignUp button is disabled");
		}*/
	}
	
	public void Verify_User_signed_Up(WebDriver driver)
	{
		//First Verification
		String SignupSuccessfullURL = driver.getCurrentUrl();
		boolean SignUPSuccess = SignupSuccessfullURL.equalsIgnoreCase("https://www2.hm.com/en_in/customer-service/thank-you.html?statusCode=success");
		Assert.assertTrue(SignUPSuccess);
		
		//Second Verification
		String pageheading = PageHeader.getText();
		boolean Heading = pageheading.equalsIgnoreCase("Thank You");
		Assert.assertTrue(Heading);
	}
	

}
