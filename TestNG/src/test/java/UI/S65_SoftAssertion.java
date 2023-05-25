package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;

public class S65_SoftAssertion {

	@Test
	public void titleTest() throws InterruptedException {
		
		SoftAssert softassert = new SoftAssert();
		String expectedtitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String expectedtext = "Search";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		String actualtitle = driver.getTitle();
		System.out.println("Verifying title");
		softassert.assertEquals(actualtitle, expectedtitle,"Title verification failed");
		Thread.sleep(3000);
		String actualtext = driver.findElement(By.id("//td[@class='gh-td gh-sch-btn']//input[@id='gh-btn']")).getAttribute("value");
		System.out.println("Verifying text");
		softassert.assertEquals(actualtext, expectedtext,"Text verification failed");
		System.out.println("Closing browser");
		driver.close();
		softassert.assertAll();
}
}
