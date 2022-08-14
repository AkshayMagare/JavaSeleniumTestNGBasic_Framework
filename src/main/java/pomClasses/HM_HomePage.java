package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HM_HomePage 
{
	@FindBy(xpath="(//a[@data-tracking-label='men'])[1]")private WebElement Men;
	@FindBy(xpath="(//a[text()='Shirts'])[1]")private WebElement Shirts;
	
	
	public HM_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
		
	public void moveHM_HomePageMen(WebDriver driver) throws InterruptedException
	{	
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveToElement(Men).perform();
	}
	
	public void clickHM_HomePageShirts() throws InterruptedException
	{
		Thread.sleep(3000);
		Shirts.click();
	}
	

}
