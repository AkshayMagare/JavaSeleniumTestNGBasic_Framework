package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HM_CustomerContact
{
	@FindBy(xpath= "//button[contains(text(),'Accept')]")private WebElement cookies;
	@FindBy(xpath ="(//a[text()='Customer Service'])[1]") private WebElement CustomerService;
	@FindBy(xpath = "//a[text()='contact us']") private WebElement ContactUs;
	@FindBy(xpath = "//p[text()='000 800 050 1633']") WebElement contactNum;
	
	public HM_CustomerContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public boolean Verify_Contact_info_of_HM()
	{
		cookies.click();
		CustomerService.click();
		ContactUs.click();
		
		String actContact = contactNum.getText();
		//return actContact;
		System.out.println(actContact);
		
		boolean HM_ACTNumber = actContact.contains("000 800 050 1633");
		
		System.out.println(HM_ACTNumber);
		
		return HM_ACTNumber;
		
	}
	

}
