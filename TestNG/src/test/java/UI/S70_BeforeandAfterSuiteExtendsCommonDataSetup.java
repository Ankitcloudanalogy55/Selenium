package UI;

import org.testng.annotations.Test;

import Common.BeforeandAfterSuite;

public class S70_BeforeandAfterSuiteExtendsCommonDataSetup extends BeforeandAfterSuite {

	// Method = 1 or Test = 1
	@Test(priority = 1, groups = "regression")
	public void aTest1() {
		System.out.println("Test 1");
	}

	// Method = 2 or Test = 2
	@Test(priority = 2, description = "This is logout test")
	public void aTest2() {
		System.out.println("Test 2");
	}

	// Method = 3 or Test case = 3
	@Test(groups = { "regression", "bvt" })
	public void bTest3() {
		System.out.println("Test 3");
	}

	// Method = 4 or Test case = 4
	@Test(groups = "bvt")
	public void bTest4() {
		System.out.println("Test 4");
	}
}
