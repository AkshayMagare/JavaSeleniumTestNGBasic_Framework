package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.HM_FavBaseClass;
import pomClasses.HM_SelectLangPage;
import pomClasses.HM_SignInPage;
import pomClasses.Redirection_of_HM_LOGO;

public class Verify_Redirection_Of_HM_Logo_03 extends HM_FavBaseClass
{
	Redirection_of_HM_LOGO Logo;
	
	@BeforeClass
	public void openBrowser()
	{
		initializeBrowser();
		
		HM_SelectLangPage Lang=new HM_SelectLangPage(driver);
		Lang.HMSelectLangauge();
	}
	
	@BeforeMethod
	public void signinToApp() throws InterruptedException
	{
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.clickHM_SignInPage();
		signin.inpHM_SignInPageEmail();
		signin.inpHM_SignInPagePwd();
		signin.clickHM_SignInPageSignBtn();
		
		Thread.sleep(3000);
		Logo=new Redirection_of_HM_LOGO(driver);
		Logo.Redirect_To_Favourites();
		
	}
	
	@Test
	public void Verify_Redirection_of_HM_Logo()
	{
		
		Logo.RedirectionHMLogo(driver);
		
		
	}
	
	
	@AfterMethod (enabled = false)
	public void signOutApp()
	{
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	

}
