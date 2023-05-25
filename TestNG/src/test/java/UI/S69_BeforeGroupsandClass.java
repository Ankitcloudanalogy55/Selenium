package UI;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class S69_BeforeGroupsandClass {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Run before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Run after class");
	}
	
	@BeforeGroups(value="regression")
	public void beforeGroup() {
		System.out.println("Run before regression group");
	}
	
	@AfterGroups(value="regression")
	public void afterGroup() {
		System.out.println("Run after regression group");
	}
	
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
}
