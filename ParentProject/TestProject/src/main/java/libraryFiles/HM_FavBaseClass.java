package libraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class HM_FavBaseClass 
{
	public WebDriver driver;
	 public void initializeBrowser() throws IOException
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\akshay.magare\\Documents\\Automation\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		 driver.get(PropertyFile.property_file_reader("URL"));
	 }

}
