package UI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Common.BaseTest;

public class S76_ListenersDemoTest extends BaseTest{

	@Test(retryAnalyzer = Common.Retry.class)
	public void launchApp() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("//input[@id='user-nam']")).sendKeys("standard_user");
		
	}
}
