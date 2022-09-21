package test_cases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.automationTest.pages.HM_SignInPage;
import com.automationTest.pages.Redirection_of_HM_LOGO;

import extentListeners.ExtentListeners;

public class HM_Redirection_Of_HM_Logo extends ExtentListeners
{
	 Redirection_of_HM_LOGO Logo;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initializeBrowser();	
	}
	
	@BeforeMethod
	public void signinToApp() throws InterruptedException, IOException
	{
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.Accept_cookies();
		Thread.sleep(3000);
		Logo=new Redirection_of_HM_LOGO(driver);
		Logo.Redirect_To_Favourites();
	}
	
	@Test(priority = 1)
	public void Verify_Redirection_of_HM_Logo()
	{
		Logo.RedirectionHMLogo(driver);
		//test.info("User successfully redirect to redirected to Home page");	
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	

}
