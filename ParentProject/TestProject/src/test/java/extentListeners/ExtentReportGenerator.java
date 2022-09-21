package extentListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
	
	static ExtentReports Extent;
	
	public static ExtentReports extentReportGenerator()
	{
		
		String path = System.getProperty("user.dir")+"//Reports//ExtentReprtHMSite.html";
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(path);
		
		reporter.config().setReportName("HMSiteReport");
		reporter.config().setTheme(Theme.DARK);
		
		Extent=new ExtentReports();
		Extent.attachReporter(reporter);
		
		Extent.setSystemInfo("Environment", "Production");
		Extent.setSystemInfo("OS", "Windows");
		Extent.setSystemInfo("RunBy", "Akshay");
		
		return Extent;
		
		
	}

}
