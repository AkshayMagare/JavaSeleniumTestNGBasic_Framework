package com.automationTest.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import libraryFiles.PropertyFile;

public class HM_SignInPage 
{
	//button[contains(text(),'Accept')]
	//button[contains(text(),'Accept all cookies')])[2]
	@FindBy(xpath= "//*[@id='onetrust-accept-btn-handler']")private WebElement cookies;
	@FindBy(xpath= "(//a[@data-remodal-trigger='signin'])[1]") private WebElement SignIn;
	@FindBy(xpath= "//input[@name='j_username']") private WebElement Email;
	@FindBy(xpath= "//input[@name='j_password']") private WebElement Pwd;
	//@FindBy(xpath= "//button[text()='Sign in']") private WebElement SignBtn;
	@FindBy(xpath= "//*[@class='button large js-set-session-storage btn-login']") private WebElement SignBtn;
	@FindBy(xpath= "(//a[@data-signin-state='signedin'])[1]") private WebElement MyAccountheader;
	@FindBy(xpath= "//a[text()='My Account'][1]") private WebElement MyAccount;
	@FindBy(xpath= "//a[text()='India']") private WebElement Langauge;
	@FindBy(xpath= "//*[@class='Heading-module--general__2dfw7 CardFront--name__GbrJj Heading-module--medium__18h30']") private WebElement Name;
	@FindBy(xpath= "(//*[@class='UserMenu-module--textWithIcon__3CfLB'])[7]") private WebElement SignOut;
	
	public HM_SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Accept_cookies() throws InterruptedException
	{
		Thread.sleep(3000);
		cookies.click();
	}

	public void Sign_in_Process() throws InterruptedException, IOException
	{
		//Langauge.click();
		Thread.sleep(2000);
		
		SignIn.click();
		Email.sendKeys(PropertyFile.property_file_reader("email"));
		Pwd.sendKeys(PropertyFile.property_file_reader("Password"));
		SignBtn.click();
		
		Thread.sleep(10000);
	}
	
	
	public void Verify_User_logged_In(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", MyAccountheader);
		Thread.sleep(10000);
        
		
		String URL=driver.getCurrentUrl();
        System.out.println(URL);	
		boolean Loggedin = URL.equalsIgnoreCase("https://www2.hm.com/en_in/account");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(Loggedin, true);
		sa.assertAll();
		
		/*String MyName=Name.getText();
		System.out.println(MyName);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(MyName, "Aksh");
		sa.assertAll();*/
		
		
		}
	
//	public void Verify_User_signed_out() {
//		
//		SignOut.click();
//		System.out.println("User is Signed Out");
//	}
	}

	

