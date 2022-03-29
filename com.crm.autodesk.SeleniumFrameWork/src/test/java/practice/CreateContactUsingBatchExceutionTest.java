package practice;

import org.testng.annotations.Test;

public class CreateContactUsingBatchExceutionTest {
	
	@Test(groups= {"integrationTest","regressionTest"})
	public void createContact() {
		System.out.println("running create Contact Test");
	}
	
	@Test(groups="regressionTest")
	public void createContactWithOrganisation() {
		System.out.println("running create Contact With OrganisationTest");
	}
	
	@Test(groups="integrationTest")
	public void createContactWithAddress() {
		System.out.println("running create Contact With Address");
	}

}
