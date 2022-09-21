package test_cases;

import java.io.IOException;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.automationTest.pages.HM_FavouritePage;
import com.automationTest.pages.HM_Home_Page;

import com.automationTest.pages.HM_SignInPage;

import extentListeners.ExtentListeners;




public class HM_Add_Product_In_Favourite_List extends ExtentListeners
{
	
	@BeforeClass
	public void openBrowser() throws InterruptedException, IOException
	{
		initializeBrowser();
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.Accept_cookies();
		
		//test.info("Cookies Accepted");
	}
	
	@Test(priority=1)
	public void verifyProductAddToFavorite() throws InterruptedException
	{
		HM_Home_Page home=new HM_Home_Page(driver);
		home.Select_Men_Category(driver);
		
		
		HM_FavouritePage favourite=new HM_FavouritePage(driver);
		favourite.clickPatternedresortHM_MenShirtsPage(driver);
		favourite.clickHM_FavouritePageBtn(driver);
		
		//test.info("Product successfully added into Favourites");
		
	}
	
	@Test(priority=2)
	public void verifyProductRemovedFromFavorite()
	{
		HM_FavouritePage favourite=new HM_FavouritePage(driver);
		favourite.Remove_product_from_Favourites(driver);
		
		//test.info("Product successfully Removed from Favourites");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}

}
