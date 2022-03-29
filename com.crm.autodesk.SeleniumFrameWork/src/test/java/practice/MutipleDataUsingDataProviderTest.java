package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MutipleDataUsingDataProviderTest {
	
	@DataProvider()
	public Object[][] getData() {
		Object[][] objData = new Object[2][3];
		
		objData[0][0]= "channa";
		objData[0][1]= "keshava@gmail.com";
		objData[0][2]= "9876543210";
		
		objData[1][0]= "Reddy";
		objData[1][1]= "reddy@gmail.com";
		objData[1][2]= "9876543211";
		
		return objData;
	}
	@Test(dataProvider="getData")
	public void MutipleData(String name,String emailId,String phoneNumber) {
		System.out.println(name);
		System.out.println(emailId);
		System.out.println(phoneNumber);
     }

}
