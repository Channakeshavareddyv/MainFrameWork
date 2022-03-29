package com.crm.autodesk.leadtest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CreatingNewLeadPage;
import com.crm.autodesk.ObjectRepository.DuplicatingLeadPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LeadInformationPage;
import com.crm.autodesk.ObjectRepository.LeadsPage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementionClass.class)
public class CreateLeadWithValidMandatoryDetailsAndDuplicateTheLeadFromLeadsInformationPageAndEditTheDetailsAndThenDeleteTest extends BaseClass{
	
        @Test(groups={"functionalTest","regressionTest","integrationTest"})
        public void createLeadWithValidMandatoryDetailsAndDuplicateTheLeadFromLeadsInformationPageAndEditTheDetailsAndThenDeleteTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String lastName = EU.getDataFromExcel("Sheet6", 1,1)+"_"+JU.getRanDomNum();
		String companyName = EU.getDataFromExcel("Sheet6", 1,2)+"_"+JU.getRanDomNum();
		String suggestions = EU.getDataFromExcel("Sheet6", 1,13);
		String expectedLead = EU.getDataFromExcel("Sheet6", 1,14);
			 
		 //creating Home page object and calling the clickOnLeadsLink method
		 HomePage hp = new HomePage(driver);
		 hp.clickOnLeadsLink();
		 
		 //creating Leads page object and calling the clickOnAddIconImage method
		 LeadsPage leapag = new LeadsPage(driver);
		 leapag.clickOnAddIconImage();
		
		 //creating CreatingNewLead page object and calling the clickOnSaveButton method
		 CreatingNewLeadPage crealead = new CreatingNewLeadPage(driver);
		 crealead.clickOnSaveButton(lastName, companyName);
		 hp.clickOnLeadsLink();
		
		 
		 leapag.searchForLastNameAndClick(driver, lastName, suggestions);
		 
		 //creating LeadInformation page object and calling the clickOnDuplicateButton method
		 LeadInformationPage leadInfo=new LeadInformationPage(driver);
		 leadInfo.clickOnDuplicateButton();
		 
		 //creating DuplicatingLeadPage page object and calling the creatingDuplicatingLead method
		 DuplicatingLeadPage dp = new DuplicatingLeadPage(driver);
		 String DuplicateName = lastName+"_Duplicate";
		 dp.creatingDuplicatingLead(DuplicateName);
		 
		 //creating Home page object and calling the clickOnLeadsLink method
		 hp.clickOnLeadsLink();
		 
		 //creating Leads page object and calling the searchForDuplicateLastNameAndClick method
		 leapag.searchForDuplicateLastNameAndClick(driver,lastName, DuplicateName, suggestions);
		 
		 //creating LeadInformation page object and calling the deleteDuplicateLead method
		 leadInfo.deleteDuplicateLead(driver);
		 
		 //creating Leads page object and calling the noLeadFound method
		 String acutalLead = leapag.noLeadFound(driver,DuplicateName,suggestions);
		 
		 //verifying the duplicate lead present or not
		 if(acutalLead.contains(expectedLead)) {
			 System.out.println("PASS : NO LEAD MESSAGE SHOULD BE DISPLAYED");
		 }else {
			 System.out.println("FAIL : NO LEAD MESSAGE SHOULD NOT BE DISPLAYED");
		 }
    }
}
