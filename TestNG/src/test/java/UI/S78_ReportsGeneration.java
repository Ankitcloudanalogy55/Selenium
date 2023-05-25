package UI;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class S78_ReportsGeneration {

	@Test
	public void reportTest1() {
		Reporter.log("test 1 report");
		System.out.println("test 1");
	}
	
	@Test
	public void reportTest2() {
		System.out.println("test 2");
	}
	
	@Test
	public void reportTest3() {
		System.out.println("test 3");
	}
	
	@Test
	public void reportTest4() {
		System.out.println("test 4");
	}
}
