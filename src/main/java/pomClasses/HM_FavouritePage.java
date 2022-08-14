package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HM_FavouritePage 
{
	@FindBy(xpath="//a[@class='menu__favorites']")private WebElement favouriteBtn;
	@FindBy(xpath="//a[text()='Patterned resort shirt']")private WebElement favourites;
	
	
	public HM_FavouritePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickHM_FavouritePageBtn(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		favouriteBtn.click();
		
		String actfavo = favourites.getText();
		//System.out.println(acttext);
		String exptfavo="Patterned resort shirt";
		
		
		if(actfavo.equals(exptfavo))
		{
			System.out.println("Shirt added in favourites");
		}
		else
		{
			System.out.println("Shirt not added in favourites");
		}
		
		
	
	}
	
}
