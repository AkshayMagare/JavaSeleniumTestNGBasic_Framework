package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import LibraryFiles.HM_FavBaseClass;
import pomClasses.HM_SelectLangPage;
import pomClasses.HM_SignInPage;

public class HM_SignIn_PositiveScenario extends HM_FavBaseClass 
{
	@BeforeClass
	public void InitBrowser()
	{
		initializeBrowser();
		
		HM_SelectLangPage Lang=new HM_SelectLangPage(driver);
		Lang.HMSelectLangauge();
		
	}
	@Test
	public void Verify_User_Able_To_SignIn() throws InterruptedException
	{
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.clickHM_SignInPage();
		signin.inpHM_SignInPageEmail();
		signin.inpHM_SignInPagePwd();
		signin.clickHM_SignInPageSignBtn();
		signin.Verify_User_logged_In(driver);
		
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
	}

}
