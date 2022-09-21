package com.automationTest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;


public class HM_About_Company
{
	JavascriptExecutor js;
	SoftAssert sa=new SoftAssert();
	
	@FindBy(xpath= "//button[contains(text(),'Accept')]")private WebElement cookies;
	@FindBy(xpath ="(//a[text()='Customer Service'])[1]") private WebElement CustomerService;
	@FindBy(xpath = "//a[text()='contact us']") private WebElement ContactUs;
	@FindBy(xpath = "//p[text()='000 800 050 1633']") private WebElement contactNum;
	
	@FindBy(xpath = "//a[text()='Corporate Info']") private WebElement CorporateInfo;
	@FindBy(xpath = "//p[text()='Registered Number:CIN- U74140DL2013FTC262231']") private WebElement CINnumber;
	
	@FindBy(xpath ="//a[contains(text(),'CSR Committee Composition')]") private WebElement CSRCommitteeComposition;
	@FindBy(xpath = "(//div[@class='read-more-wrapper']/p)[2]") private WebElement CommitteeName;
	
	
	@FindBy(xpath = "(//*[text()='Legal & Privacy'])[2]") private WebElement Legal_and_Privacy;
	
	
	//@FindBy(xpath = "//b[@id='page-content']/div/div/div/p[2]/b/text()[1]") private WebElement CommitteeName1;
	
		
	public HM_About_Company(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
 
	public void Redirection_to_Customer_Service() {
		
		cookies.click();
		CustomerService.click();
		
	}
	
	public void Verify_Contact_info_of_HM()
	{
		
		ContactUs.click();
		
		String actContact = contactNum.getText();
		System.out.println(actContact);
		
		boolean HM_ACTNumber = actContact.contains("000 800 050 1633");
		
		System.out.println(HM_ACTNumber);
		
		sa.assertEquals(HM_ACTNumber, true, "Failed: Validated number is incorrect");
		sa.assertAll();
		
		Reporter.log("=============Validated Contact Number is correct================", true);
		
	}
	
	public void Verify_Corporate_info_of_HM(WebDriver driver) 
	
	{
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", CorporateInfo);
		//CorporateInfo.click();
		String CIN = CINnumber.getText();
		System.out.println(CIN);
		
		sa.assertEquals(CIN, "Registered Number:CIN- U74140DL2013FTC262231", "Failed: Wrong CIN Number");
		
		Reporter.log("=================Validated CIN Number is correct===================", true);
	}
	
	public void Verify_CSR_Committee_Composition_of_HM()
	{
		
		js.executeScript("arguments[0].click();", CSRCommitteeComposition);
		String actCommitteeName = CommitteeName.getText();
		System.out.println(actCommitteeName);
		
		boolean CommitteeMember1 = actCommitteeName.contains("1. Mr. Anders Peter Jonasson, Director");
		boolean CommitteeMember2 = actCommitteeName.contains("2. Mr. Nils Axel Vinge, Director");
		boolean CommitteeMember3 = actCommitteeName.contains("3. Mr. Louis Jacques R. Coucke, Director");
		
		sa.assertEquals(CommitteeMember1, true);
		sa.assertEquals(CommitteeMember2, true);
		sa.assertEquals(CommitteeMember3, true);
		
		sa.assertAll();
	
	
	}
	
	public void Verify_GROUP_PRIVACY_NOTICE_of_HM(WebDriver driver)
	{
		
		js.executeScript("arguments[0].click();", Legal_and_Privacy);
		
		String LegalAndPrivacyLink = driver.getCurrentUrl();
		System.out.println(LegalAndPrivacyLink);
		
		sa.assertEquals(LegalAndPrivacyLink, "https://www2.hm.com/en_in/customer-service/legal-and-privacy/privacy-link.html");
		sa.assertAll();
		
		
	}
	
	
	
	
	

}
