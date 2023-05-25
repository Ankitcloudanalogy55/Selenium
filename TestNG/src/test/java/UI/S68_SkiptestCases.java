package UI;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class S68_SkiptestCases {
	
	Boolean datasetup = false;

	// Approach 1
	@Test(enabled = false)
	public void skipTest1() {
		System.out.println("Skipping this test as it is not complete");
	}

	// Approach 2
	@Test
	public void skipTest2() {
		System.out.println("Skipping this test forcefully");
		throw new SkipException("Skipping Test");
	}

	// Approach 3
	@Test
	public void skipTest3() {
		
		System.out.println("Skipping this test based on condition");
		if(datasetup==true) {
			System.out.println("Execute test");
		}
		
		else {
			System.out.println("Do not execute");
			throw new SkipException("Do not execute further Test");
		}
	}
}
