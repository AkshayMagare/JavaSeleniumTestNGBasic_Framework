package extentListeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import libraryFiles.HM_FavBaseClass;
import utility.TakeScreenshotOfApp;

public class ExtentListeners extends HM_FavBaseClass implements ITestListener  
{
	
	
    ExtentReports extent =ExtentReportGenerator.extentReportGenerator();
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test Case Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(TakeScreenshotOfApp.captureScreenShot(driver, result.getName()), "Failed Screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, "Test Case skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
