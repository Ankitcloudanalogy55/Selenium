package Common;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Utilities.testUtils;

public class Listeners extends testUtils implements ITestListener {

	// Methods -
	public void onTestStart(ITestResult result) {
		System.setProperty("org.uncommons.reportng.title","Selenium Report");
		Reporter.log("Method name is = " + result.getName());
		System.out.println("Test case is starting");

	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status of execution is = " + result.getStatus());

	}

	public void onTestFailure(ITestResult result) {					
		System.out.println("Test failed - screenshot captured");
		
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  System.setProperty("org.uncommons.reportng.escape-output", "false");
      Reporter.log("<a href=\"C:\\Users\\Cloud Analogy\\OneDrive\\Testing\\TestNG\\screenshot\\Thu-Apr-27-11-17-34-IST-2023.png\">Fail Test Results</a>");
    }

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
