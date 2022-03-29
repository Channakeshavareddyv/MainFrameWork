package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementionClass.class)
public class SampleExtentReportsExample extends BaseClass{
	@Test
	public void createTest() {
		System.out.println("RUNNING THE CREATE TEST");
	}
	@Test
	public void modifyTest() {
		System.out.println("RUNNING THE MODIFY TEST");
		//Assert.fail();
	}
	@Test(dependsOnMethods="modifyTest")
	public void deleteTest() {
		System.out.println("RUNNING THE DELETE TEST");
		
	}

}
