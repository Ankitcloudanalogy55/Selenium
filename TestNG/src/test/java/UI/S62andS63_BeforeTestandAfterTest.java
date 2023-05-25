package UI;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BeforeandAfterSuite;

public class S62andS63_BeforeTestandAfterTest extends BeforeandAfterSuite{

	@BeforeTest
	public void loginToApplication(){
		System.out.println("Login to application (@Before Test)");
	} 
	
	@AfterTest
	public void logoutFromApplication(){
		System.out.println("Logout from application (@After Test)");
	}
	
	@BeforeMethod
	public void connectToDB() {
		System.out.println("DB Connected (@Before Method)");
	}
	
	@AfterMethod
	public void disConnectToDB() {
		System.out.println("DB DisConnected (@After Method)");
	}
	
	// Method = 1 or Test = 1
	@Test(priority = 1, description = "This is login test")
	public void aTest1() {
		System.out.println("Test 1");
	}

	// Method = 2 or Test = 2
	@Test(priority = 2, description = "This is logout test")
	public void aTest2() {
		System.out.println("Test 2");
	}

}

//NOTE -
//@Test annotation is use to convert method in TestNG test cases
//Method Which We Call Test Cases In Selenium
//TestNG execute your methods "alphabetically"
//TestNG is also execute your methods with "priority" based
//@BeforeTest & @AfterTest annotation run before "method" and after "method" 
//@BeforeMethod & @AfterMethod annotation run before each "method" and run after each "method" 