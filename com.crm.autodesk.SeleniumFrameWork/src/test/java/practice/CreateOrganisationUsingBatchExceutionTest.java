package practice;

import org.testng.annotations.Test;

public class CreateOrganisationUsingBatchExceutionTest {
	
	@Test(groups="integrationTest")
	public void createOrganisation() {
		System.out.println("running create Organisation Test");
	}
	
	@Test(groups="regressionTest")
	public void createOrganisationWithIndustry() {
		System.out.println("running create Organisation With IndustryTest");
	}
	
	@Test(groups= {"integrationTest","regressionTest"})
	public void createOrganisationWithAddress() {
		System.out.println("running create Organisation With Address");
	}

}
