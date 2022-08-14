package testClasses;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LibraryFiles.HM_FavBaseClass;
import pomClasses.HM_CustomerContact;
import pomClasses.HM_SelectLangPage;

public class HM_Test_CustomerContact extends HM_FavBaseClass
{
	@BeforeClass
	public void BrowserOpen()
	{
		initializeBrowser();
		HM_SelectLangPage Lang=new HM_SelectLangPage(driver);
		Lang.HMSelectLangauge();
	}
	
	@Test
	public void Verify_CustomerContact()
	{
        HM_CustomerContact customer=new HM_CustomerContact(driver);
        boolean actContact=customer.Verify_Contact_info_of_HM();
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actContact, true, "Failed: Validated number is incorrect");
		soft.assertAll();
		
		Reporter.log("validated contact no is correct", true);
		
	}
	
	@AfterClass
	public void BrowserClose()
	{
		driver.close();
	}

}
