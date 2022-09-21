package test_cases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationTest.pages.HM_SignInPage;
import com.automationTest.pages.Sign_up_newsletter;

import extentListeners.ExtentListeners;

public class HM_Sign_Up_Newsletter extends ExtentListeners{
	
	@BeforeClass
	public void BrowserOpen() throws InterruptedException, IOException
	{
		initializeBrowser();
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.Accept_cookies();;
	}

	@Test
	public void sign_Up_Newsletter() throws InterruptedException
	{
		Sign_up_newsletter SUN=new Sign_up_newsletter(driver);
		SUN.redirectToSignUpPage();
		SUN.Sign_Up_for_Newsletter(driver);
		SUN.Verify_User_signed_Up(driver);
		
	}
	
	@AfterClass(enabled=false)
	public void BrowserClose()
	{
		driver.close();
	} 
}
