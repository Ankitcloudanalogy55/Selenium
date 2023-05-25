package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver = null;
	
	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Browser Start");
	}
	
	@AfterSuite
	public void closingBrowser() {
		driver.close();
		System.out.println("Browser Closed");
	}
}
