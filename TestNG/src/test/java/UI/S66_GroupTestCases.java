package UI;

import org.testng.annotations.Test;

import Common.BeforeandAfterSuite;

@Test(groups = "user-registration")
public class S66_GroupTestCases extends BeforeandAfterSuite{

	// Method = 1 or Test case = 1
	@Test(priority = 1, groups = "regression")
	public void aTest1() {
		System.out.println("Test 1");
	}

	// Method = 2 or Test case = 2
	@Test(priority = 2, groups = "regression")
	public void bTest2() {
		System.out.println("Test 2");
	}

	// Method = 3 or Test case = 3
	@Test(groups={"regression","bvt"})
	public void bTest3() {
		System.out.println("Test 3");
	}

	// Method = 4 or Test case = 4
	@Test(groups = "bvt")
	public void bTest4() {
		System.out.println("Test 4");
	}
}
//NOTE - 
//We can configure groups class level or method level as well
//groups is high level than priority
