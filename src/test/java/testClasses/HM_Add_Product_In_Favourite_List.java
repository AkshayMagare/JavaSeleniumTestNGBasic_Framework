package testClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.HM_FavBaseClass;
import pomClasses.HM_FavouritePage;
import pomClasses.HM_HomePage;
import pomClasses.HM_MenShirtsPage;
import pomClasses.HM_SelectLangPage;
import pomClasses.HM_SignInPage;

public class HM_Add_Product_In_Favourite_List extends HM_FavBaseClass
{
	
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
		
	}
	
	@Test
	public void verifyProductAddToFavorite() throws InterruptedException
	{
		HM_HomePage home=new HM_HomePage(driver);
		home.moveHM_HomePageMen(driver);
		home.clickHM_HomePageShirts();
		
		HM_MenShirtsPage shirt=new HM_MenShirtsPage(driver);
		shirt.clickPatternedresortHM_MenShirtsPage(driver);
		
		HM_FavouritePage favourite=new HM_FavouritePage(driver);
		favourite.clickHM_FavouritePageBtn(driver);
		
		
		
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
