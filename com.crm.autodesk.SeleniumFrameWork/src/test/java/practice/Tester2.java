package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tester2 {
		
		@Test(retryAnalyzer = com.crm.autodesk.GenericUtility.RetryAnalyzerImplementionClass.class)
		public void test() {
			
			System.out.println("trying");
			Assert.assertEquals(true, true);
			
		
		}
}
