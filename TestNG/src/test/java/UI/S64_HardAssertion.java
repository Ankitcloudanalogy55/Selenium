package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class S64_HardAssertion {

	@Test
	public void titleTest() {
		String expectedtitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);		
		driver.close();
		
		
	}

}
//NOTE - 
// Hard assert if fails then next execution not move further it stops with that posiiton