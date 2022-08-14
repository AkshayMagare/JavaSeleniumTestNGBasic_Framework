package pomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HM_SignInPage 
{

	@FindBy(xpath= "//button[contains(text(),'Accept')]")private WebElement cookies;
	@FindBy(xpath= "(//a[@data-remodal-trigger='signin'])[1]") private WebElement SignIn;
	@FindBy(xpath= "//input[@name='j_username']") private WebElement Email;
	@FindBy(xpath= "//input[@name='j_password']") private WebElement Pwd;
	@FindBy(xpath= "//button[text()='Sign in']") private WebElement SignBtn;
	@FindBy(xpath= "(//a[@data-signin-state='signedin'])[1]") private WebElement MyAccountheader;
	@FindBy(xpath= "//a[text()='My Account'][1]") private WebElement MyAccount;
	

	
	public HM_SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickHM_SignInPage() throws InterruptedException
	{
		cookies.click();
		
		Thread.sleep(2000);
		SignIn.click();
	}
	
	public void inpHM_SignInPageEmail()
	{
		Email.sendKeys("magareakshay445@gmail.com");
	}
	
	public void inpHM_SignInPagePwd()
	{
		Pwd.sendKeys("Akshay@16");
	}
	
	public void clickHM_SignInPageSignBtn()
	{
		SignBtn.click();
	}
	
	public void Verify_User_logged_In(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", MyAccountheader);
        String URL=driver.getCurrentUrl();
        
        System.out.println(URL);
		
		boolean Loggedin = URL.equalsIgnoreCase("https://www2.hm.com/en_in/account");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(Loggedin, true);
		sa.assertAll();
		
		}
	}

	

