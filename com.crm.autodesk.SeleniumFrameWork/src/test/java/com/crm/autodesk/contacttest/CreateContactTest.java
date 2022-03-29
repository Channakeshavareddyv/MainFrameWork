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
import com.crm.autodesk.ObjectRepository.HomePage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementionClass.class)
public class CreateContactTest extends BaseClass{
    
    	 @Test(groups="functionalTest")
    	 public void createContactTest() throws EncryptedDocumentException, IOException {
    	 String LastNameData = EU.getDataFromExcel("Sheet2", 1, 1)+"_"+JU.getRanDomNum();
    	 
    	//creating the HomePage object and calling respective method
    	 HomePage hp=new HomePage(driver);
    	 hp.clickOnContactLink();
    	 
    	//creating the ContactPage object and calling respective method
    	 ContactPage conpage=new ContactPage(driver);
    	 conpage.clickOnAddIconImage();
    	 
    	//creating the CreatingNewContact object and calling respective method
    	 CreatingNewContact creatcon=new CreatingNewContact(driver);
    	 creatcon.createContactWithContactName(LastNameData);
    	 
    	//creating the ContactInformationPage object and calling respective method
    	 ContactInformationPage conInfo=new ContactInformationPage(driver);
    	 String actualContact = conInfo.verfiyContactInformation();
    	 
    	 //verifying contact is created or not
    	 if(actualContact.contains(LastNameData)) {
    		 System.out.println("PASS : CONTACT IS CREATED WITH LAST NAME");
    	 }else {
    		 System.out.println("FAIL : CONTACT IS NOT CREATED WITH LAST NAME");
    	 }
    	 Assert.assertEquals(actualContact.contains(LastNameData), true);
    	 
	}
	
}


