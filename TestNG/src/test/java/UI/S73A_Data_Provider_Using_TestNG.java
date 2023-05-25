package UI;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class S73A_Data_Provider_Using_TestNG {

	@DataProvider(name = "second dataprovider")
	public Object[][] dataset1(Method m) {
		
		
		
		Object[][] testdata = null;
		if(m.getName().equals("test"))
		{
		testdata = new Object[][]
		{ 
		{ "username", "password" }, 
		{ "username1", "password1" },
		{ "username2", "password2" }, 
		{ "username3", "password3" }, 
		};
		}
			
		else if(m.getName().equals("test1"))
		{ 
		testdata = new Object[][]
		{
		{ "username", "password", "test" }, 
		{ "username1", "password1", "test1" },
		{ "username2", "password2", "test2" }, 
		{ "username3", "password3", "test3" }, 
		};		
		}
		
		else if(m.getName().equals("test2"))
		{ 
		testdata = new Object[][]
		{
		{ "username", "password", "test","description" }, 
		{ "username1", "password1", "test1","description1" },
		{ "username2", "password2", "test2","description2" }, 
		{ "username3", "password3", "test3","description3" }, 
		};		
		}
		return testdata;
				
	}
}
