package UI;

import org.testng.annotations.Test;

public class S73B_Data_Provider_Using_TestNG {

	@Test(dataProvider = "second dataprovider",dataProviderClass=S73A_Data_Provider_Using_TestNG.class)
	public void test(String username, String password) {
		System.out.println(username + "==" + password);
	}

	@Test(dataProvider = "second dataprovider",dataProviderClass=S73A_Data_Provider_Using_TestNG.class)
	public void test1(String username, String password, String test) {
		System.out.println(username + "==" + password + "==" + test);
	}

	@Test(dataProvider = "second dataprovider",dataProviderClass=S73A_Data_Provider_Using_TestNG.class)
	public void test2(String username, String password, String test, String description) {
		System.out.println(username + "==" + password + "==" + test+"=="+description);
	}

	}

