package Common;

import org.testng.annotations.*;

public class BeforeandAfterSuite {
	
	@BeforeSuite
	public void dataSetup() {
		System.out.println("Common data setup");
	}
	
	@AfterSuite
	public void dataTearDown() {
		System.out.println("Common data cleanup");
	}


}
