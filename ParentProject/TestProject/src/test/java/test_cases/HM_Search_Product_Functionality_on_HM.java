package test_cases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationTest.pages.HM_SignInPage;
import com.automationTest.pages.SearchResults;

import extentListeners.ExtentListeners;

public class HM_Search_Product_Functionality_on_HM extends ExtentListeners{
	
	@BeforeClass
	public void BrowserOpen() throws InterruptedException, IOException
	{
		initializeBrowser();
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.Accept_cookies();;
	}

	@Test
	public void Search_Product()
	{
		SearchResults SR=new SearchResults(driver);
		SR.Search_Product_Functionality(driver);	
	}
	
	@AfterClass
	public void BrowserClose()
	{
		driver.close();
	}
}
