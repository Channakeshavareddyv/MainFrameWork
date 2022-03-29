package com.crm.autodesk.contacttest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.ContactInformationPage;
import com.crm.autodesk.ObjectRepository.ContactPage;
import com.crm.autodesk.ObjectRepository.CreatingNewContact;
import com.crm.autodesk.ObjectRepository.CreatingNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementionClass.class)
public class CreateContactWithOrganisationTest extends BaseClass{
	    @Test(groups="regressionTest")
	    public void createContactWithOrganisationTest() throws EncryptedDocumentException, IOException {
	    	
	    String LASTNAME = EU.getDataFromExcel("Sheet2", 2, 1)+"_"+JU.getRanDomNum();
	    String ORGANISATIONNAME = EU.getDataFromExcel("Sheet2", 2, 4)+"_"+JU.getRanDomNum();
		 
		 //creating the HomePage object and calling respective method
		 HomePage hp = new HomePage(driver);
		 hp.clickOnOrganizationLink();
		 
		 //creating the OrganizationsPage object and calling respective method
		 OrganizationsPage orgPage = new OrganizationsPage(driver);
		 orgPage.clickOnAddIconImage();
		
		 //creating the CreatingNewOrganizationPage object and calling respective method
		 CreatingNewOrganizationPage creNewOrg = new CreatingNewOrganizationPage(driver);
		 creNewOrg.creatingOrganizationWithOrganizationName(ORGANISATIONNAME);
		
		 //creating the OrganizationInformationPage object and calling respective method
		 OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		 String actualOrganizatio = orgInfo.verfiyOrganizationInformation();
		
		 //Verifying the Organization Information
		 if(actualOrganizatio.contains(ORGANISATIONNAME)) {
			System.out.println("PASS : Organization CREATED IS CORRECT");
		 }
		 else {
			System.out.println("FAIL : Organization CREATED IS NOT CORRECT");
		 }
		
		 //this method will click on contact link
		 hp.clickOnContactLink();
   	 
		 //creating the ContactPage object and calling respective method
	   	 ContactPage conpage=new ContactPage(driver);
	   	 conpage.clickOnAddIconImage();
	   	 
	     //creating the CreatingNewContact object and calling respective method
	   	 CreatingNewContact creatcon=new CreatingNewContact(driver);
	   	 creatcon.createContactWithOrganizationName(driver, LASTNAME, ORGANISATIONNAME);
	   	 
	     //creating the ContactInformationPage object and calling respective method
	   	 ContactInformationPage conInfo=new ContactInformationPage(driver);
	   	 String actualContact = conInfo.verfiyContactInformation();
	   	 
	   	 //verifying contact is created are not
//	   	 if(actualContact.contains(LASTNAME)) {
//	   		 System.out.println("PASS : CONTACT IS CREATED WITH LAST NAME WITH ORGANISATION");
//	   	 }else {
//	   		 System.out.println("FAIL : CONTACT IS NOT CREATED WITH LAST NAME WITH ORGANISATION");
//	   	 }
	   	 Assert.assertEquals(actualContact.contains(LASTNAME), true);
   	  }
}
