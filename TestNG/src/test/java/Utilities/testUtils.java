package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Common.BaseTest;

public class testUtils extends BaseTest{

	public void getScreenshot() throws IOException {
		    Date currentdate = new Date();
	        String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
	        System.out.println(screenshotfilename);
	        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Cloud Analogy\\OneDrive\\Testing\\TestNG\\screenshot/"+screenshotfilename+".png"));
}
}  														
