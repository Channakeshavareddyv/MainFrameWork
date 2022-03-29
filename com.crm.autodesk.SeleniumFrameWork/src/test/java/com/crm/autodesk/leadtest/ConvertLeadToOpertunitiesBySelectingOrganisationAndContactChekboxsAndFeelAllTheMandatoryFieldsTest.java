package com.crm.autodesk.leadtest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.ConvertLeadPage;
import com.crm.autodesk.ObjectRepository.CreatingNewLeadPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LeadInformationPage;
import com.crm.autodesk.ObjectRepository.LeadsPage;
import com.crm.autodesk.ObjectRepository.LoginPage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementionClass.class)
public class ConvertLeadToOpertunitiesBySelectingOrganisationAndContactChekboxsAndFeelAllTheMandatoryFieldsTest extends BaseClass{

	    @Test(groups="functionalTest")
	    public void convertLeadToOpertunitiesBySelectingOrganisationAndContactChekboxsAndFeelAllTheMandatoryFieldsTest() throws EncryptedDocumentException, IOException {
		String lastName = EU.getDataFromExcel("Sheet6", 1,1)+"_"+JU.getRanDomNum();
		String companyName = EU.getDataFromExcel("Sheet6", 1,2)+"_"+JU.getRanDomNum();
		String expectedLoginTitle = EU.getDataFromExcel("Sheet6", 5,3);
		String expectedHomeTitle = EU.getDataFromExcel("Sheet6", 6,3);
		String expectedLeadInfo = EU.getDataFromExcel("Sheet6", 7,3);
		String expectedconvertLeadPageInfo = EU.getDataFromExcel("Sheet6", 8,3);
		String expectedorganizationInformationPageInfo = EU.getDataFromExcel("Sheet6", 9,3);
		
	     LoginPage lp = new LoginPage(driver);
		 String actualLoginTitle = lp.getLoginTitle(driver);
		 if(actualLoginTitle.contains(expectedLoginTitle)) {
			 System.out.println("PASS : LOGIN PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : LOGIN PAGE SHOULD BE NOT DISPLAY");
		 }
			 
		 //creating the HomePage object and calling respective method
		 HomePage hp = new HomePage(driver);
		 String actualHomeTitle = hp.getHomeTitle(driver);
		 // verifying home page displayed or not
		 if(actualHomeTitle.contains(expectedHomeTitle)) {
			 System.out.println("PASS : HOME PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : HOME PAGE SHOULD BE NOT DISPLAY");
		 }
		 hp.clickOnLeadsLink();
		 
		 //creating the LeadsPage object and calling respective method
		 LeadsPage leapag = new LeadsPage(driver);
		 leapag.clickOnAddIconImage();
		 
		 //creating the CreatingNewLeadPage object and calling respective method
		 CreatingNewLeadPage crealead = new CreatingNewLeadPage(driver);
		 crealead.clickOnSaveButton(lastName, companyName);
		 
		 //verifying the lead information should be displayed or not
		 String actualLeadInfo = crealead.getLeadInformationTitle();
		 if(actualLeadInfo.contains(expectedLeadInfo)) {
			 System.out.println("PASS : LEAD INFORMATION PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : LEAD INFORMATION PAGE SHOULD NOT BE DISPLAY");
		 }
		 //creating the LeadInformationPage object and calling respective method
		 LeadInformationPage leadInfo = new LeadInformationPage(driver);
		 leadInfo.clickOnConvertLead(driver);
		 
		 //verifying the convert lead should be displayed or not
		 String actualconvertLeadPageInfo = leadInfo.convertLeadPageTitle();
		 if(actualconvertLeadPageInfo.contains(expectedconvertLeadPageInfo)) {
			 System.out.println("PASS : CONVERT LEAD PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : CONVERT LEAD PAGE SHOULD NOT BE DISPLAY");
		 }
		 //creating the ConvertLeadPage object and calling respective method
		 ConvertLeadPage conLead = new ConvertLeadPage(driver);
		 conLead.clickOnConvertLeadSaveButton();
		 
		 //verifying the organization Information should be displayed or not
		 String actualorganizationInformationPageInfo = conLead.organizationInformationTitle();
		 if(actualorganizationInformationPageInfo.contains(expectedorganizationInformationPageInfo)) {
			 System.out.println("PASS : ORGANIZATION INFORMATION PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : ORGANIZATION INFORMATION PAGE SHOULD NOT BE DISPLAY");
		 }
	}

}
