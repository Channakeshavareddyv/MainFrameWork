package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DependsOnMethodTest {
	
	@Test()
	public void createLeadTest() {
		System.out.println("Running createLeadTest");
		//Assert.fail();
	}
	
	@Test(dependsOnMethods = "createLeadTest")
	public void modifyLeadTest() {
		System.out.println("Running modifyLeadTest");
		Assert.fail();
	}
	
	@Test(dependsOnMethods="modifyLeadTest")
	public void duplicateLeadTest() {
		System.out.println("Running duplicateLeadTest");
	}
	
	@Test(dependsOnMethods="createLeadTest")
	public void deleteLeadTest() {
		System.out.println("Running deleteLeadTest");
		//Assert.fail();
	}

}
