package test_cases;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationTest.pages.HM_About_Company;
import com.automationTest.pages.HM_SignInPage;

import extentListeners.ExtentListeners;

public class HM_Test_AboutCompany extends ExtentListeners
{
    HM_About_Company customer=new HM_About_Company(driver);
	
	@BeforeClass
	public void BrowserOpen() throws IOException, InterruptedException
	{
		initializeBrowser();
		HM_SignInPage signin=new HM_SignInPage(driver);
		signin.Accept_cookies();
	}
	
	@Test(priority = 1)
	public void Verify_CustomerContact()
	{
        customer=new HM_About_Company(driver);
        customer.Redirection_to_Customer_Service();
        customer.Verify_Contact_info_of_HM();      
        //test.info("Customer contact info verified and found ok");	
	}
	
	@Test (priority = 2)
	public void Verify_Corporate_Info() {
		
		customer=new HM_About_Company(driver);
		customer.Verify_Corporate_info_of_HM(driver);
		//test.info("Corporate info of HM site verified and found ok");
	}
	
	@Test (priority = 3)
	public void Verify_CSR_Committee_Composition()
	{
		customer.Verify_CSR_Committee_Composition_of_HM();
		//test.info("CSR Commitee Composition names verified and found ok");
	}
	
	@Test (priority = 4)
	public void Verify_User_Able_To_Access_Group_Privacy_Notice() 
	{
		customer.Verify_GROUP_PRIVACY_NOTICE_of_HM(driver);
		//test.info("User successfully redirect to Group Privacy Notice of HM");
	}
	
	
	@AfterClass
	public void BrowserClose()
	{
		driver.close();
	}

}
