package com.crm.autodesk.organsationtest;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementionClass.class)
public class CreateOrganisationWithIndustryTest extends BaseClass{
         @Test(groups="integrationTest")
         public void createOrganisationWithIndustryTest() throws EncryptedDocumentException, IOException {
    	 //getting the data from the Excel file
    	 String organNameData = EU.getDataFromExcel("Sheet1", 2, 0)+"_"+JU.getRanDomNum();
    	 String industryData = EU.getDataFromExcel("Sheet1", 3, 3);
 		 
 		 //creating the HomePage object and calling respective method
 		 HomePage hp = new HomePage(driver);
 		 hp.clickOnOrganizationLink();
 		 
 		//creating the OrganizationsPage object and calling respective method
 		OrganizationsPage orgPage = new OrganizationsPage(driver);
 		orgPage.clickOnAddIconImage();
 		
 		//creating the CreatingNewOrganizationPage object and calling respective method
 		CreatingNewOrganizationPage creNewOrg = new CreatingNewOrganizationPage(driver);
 		creNewOrg.creatingOrganizationWithIndustry(organNameData, industryData);
 		
 		//creating the OrganizationInformationPage object and calling respective method
 		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
 		String actualOrganizatio = orgInfo.verfiyOrganizationInformation();
 		
 		Assert.assertEquals(actualOrganizatio.contains(organNameData), true);
// 		//Verifying the Organization Information
// 		if(actualOrganizatio.contains(organNameData)) {
//			System.out.println("PASS : Organization CREATED WITH INDUSTRY IS CORRECT");
//		}
// 		else {
// 			System.out.println("FAIL : Organization CREATED IS INDUSRTY NOT CORRECT");
// 		}
    	
	}
	
}

