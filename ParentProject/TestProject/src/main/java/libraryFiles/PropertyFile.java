package libraryFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	
	//Author Name= Akshay
	//this method is used to read property file
	
	public static String property_file_reader(String key) throws IOException
	{
		
		FileInputStream file= new FileInputStream("C:\\Users\\akshay.magare\\git\\JavaSeleniumTestNGBasic_Framework\\ParentProject\\TestProject\\HMTestData.properties");
	    
		Properties prop=new Properties();
		
		prop.load(file);
		
		String Value = prop.getProperty(key);
		
		return Value;
	}

}
