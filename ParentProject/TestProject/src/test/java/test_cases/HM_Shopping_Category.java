package test_cases;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automationTest.pages.HM_SignInPage;
import com.automationTest.pages.Shopping_Category_Page;

import extentListeners.ExtentListeners;


public class HM_Shopping_Category extends ExtentListeners
{
	Shopping_Category_Page Shop;
	
	@BeforeClass
	public void BrowserOpen() throws InterruptedException, IOException
	{
		initializeBrowser();
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.Accept_cookies();
	}
	
	@Test(priority = 1)
	public void shop_by_product_Ladies_Category()
	{
	    Shop=new Shopping_Category_Page(driver);
		Shop.shop_by_product_functionality_for_Ladies_Category(driver);
		
		//test.info("User successfully redirected to https://www2.hm.com/en_in/women/shop-by-product/dresses.html");
		
	}
	
	@Test(priority = 2)
	public void shop_by_product_Men_Category()
	{
		Shop=new Shopping_Category_Page(driver);
		Shop.shop_by_product_functionality_for_Men_Category(driver);
		
		//test.info("User successfully redirected to https://www2.hm.com/en_in/men/new-arrivals/sportswear.html");
		
	}
	@Test(priority = 3)
	public void shop_by_product_Baby_Category()
	{
	
		Shop=new Shopping_Category_Page(driver);
		Shop.shop_by_product_functionality_for_Baby_Category(driver);
		
		//test.info("User successfully redirected to https://www2.hm.com/en_in/baby/newborn/clothing.html");
	}
	
	@Test(priority = 4)
	public void shop_by_product_Sportswear_Category()
	{
		Shop=new Shopping_Category_Page(driver);
		Shop.shop_by_product_functionality_for_Sports_Category(driver);
		
		//test.info("User successfully redirected to https://www2.hm.com/en_in/sport/men/sports-accessories.html");
	}

	@AfterClass
	public void BrowserClose()
	{
		driver.close();
	}
}
