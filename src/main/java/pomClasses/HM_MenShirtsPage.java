package pomClasses;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HM_MenShirtsPage 
{
	@FindBy(xpath="(//a[@title='Patterned resort shirt'])[1]")private WebElement Patternedresort;
	@FindBy(xpath="(//button[@type='button'])[24]")private WebElement favourite;
	
	
	public HM_MenShirtsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickPatternedresortHM_MenShirtsPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Patternedresort.click();

		Thread.sleep(2000);
		favourite.click();	
	}
	
}
