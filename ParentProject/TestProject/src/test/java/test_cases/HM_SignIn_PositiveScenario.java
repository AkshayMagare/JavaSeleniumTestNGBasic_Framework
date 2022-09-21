package test_cases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationTest.pages.HM_SignInPage;

import extentListeners.ExtentListeners;


public class HM_SignIn_PositiveScenario extends ExtentListeners
{
	@BeforeClass
	public void InitBrowser() throws IOException
	{
		initializeBrowser();
	}
	
	@Test()
	public void Verify_User_Able_To_SignIn() throws InterruptedException, IOException
	{
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.Accept_cookies();
		signin.Sign_in_Process();
		signin.Verify_User_logged_In(driver);
	}
	
	@AfterClass(enabled = false)
	public void CloseBrowser()
	{
		driver.quit();
	}

}
