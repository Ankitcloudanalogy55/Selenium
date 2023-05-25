package UI;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class S80_DependencyTest {

	@Test
	public void userRegistration() {
		Reporter.log("test 1 report");
		System.out.println("test 1");
	}
	
	@Test(dependsOnMethods="userRegistration") // HARD DEPENDENCY
	public void userSearch() {
		System.out.println("test 2");
	}
	
	@Test(dependsOnMethods="userRegistration",alwaysRun=true) // SOFT DEPENDENCY
	public void reportTest3() {
		System.out.println("test 3");
	}
	
	@Test
	public void reportTest4() {
		System.out.println("test 4");
	}
}

//NOTE - 
// We can also implement in group within xml files
//<dependencies>
//<test>
//<group name="regression" depends-on ="bvt"/>
//<group name="sanity" depends-on ="bvt , regression"/>
//<class>
//</class>
////</test>
//</dependencies>