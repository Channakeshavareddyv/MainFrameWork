package com.crm.autodesk.leadtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.ConvertLeadPage;
import com.crm.autodesk.ObjectRepository.CreatingNewLeadPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LeadInformationPage;
import com.crm.autodesk.ObjectRepository.LeadsPage;
import com.crm.autodesk.ObjectRepository.LoginPage;
/**
 * this class will Convert LeadToOpertunities By Selecting Opportunity And Contact The Checkboxs And Feel All The Mandatory Fields
 * @author CHANNAKESHVA REDDY
 *
 */
@Listeners(com.crm.autodesk.GenericUtility.ListenerImplementionClass.class)
public class ConvertLeadToOpertunitiesBySelectingOpertunityAndContactTheChekboxsAndFeelAllTheMandatoryFieldsTest extends BaseClass{

	    @Test(groups="smokeTest")
	    public void convertLeadToOpertunitiesBySelectingOpertunityAndContactTheChekboxsAndFeelAllTheMandatoryFieldsTest() throws EncryptedDocumentException, IOException {
		String lastName = EU.getDataFromExcel("Sheet6", 1,1)+"_"+JU.getRanDomNum();
		String companyName = EU.getDataFromExcel("Sheet6", 1,2)+"_"+JU.getRanDomNum();
		String expectedLoginTitle = EU.getDataFromExcel("Sheet6", 19,3);
		String expectedHomeTitle = EU.getDataFromExcel("Sheet6", 20,3);
		String expectedLeadInfo = EU.getDataFromExcel("Sheet6", 21,3);
		String expectedconvertLeadPageInfo = EU.getDataFromExcel("Sheet6", 22,3);
		String expectedorganizationInformationPageInfo = EU.getDataFromExcel("Sheet6", 23,3);
		String opportunityName = EU.getDataFromExcel("Sheet6",1,9);
		String date = EU.getDataFromExcel("sheet6", 1, 10);
		String mon = EU.getDataFromExcel("sheet6", 1, 11);
		String year = EU.getDataFromExcel("sheet6", 1, 12);
	
		 LoginPage lp=new LoginPage(driver);
		 String actualLoginTitle = lp.getLoginTitle(driver);
		 if(actualLoginTitle.contains(expectedLoginTitle)) {
			 System.out.println("PASS : LOGIN PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : LOGIN PAGE SHOULD BE NOT DISPLAY");
		 }
			 
		 //creating the HomePage object and calling respective method
		 HomePage hp = new HomePage(driver);
		 String actualHomeTitle = hp.getHomeTitle(driver);
		 
		 if(actualHomeTitle.contains(expectedHomeTitle)) {
			 System.out.println("PASS : HOME PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : HOME PAGE SHOULD BE NOT DISPLAY");
		 }
		 hp.clickOnLeadsLink();
		 
		 //create object of LeadsPage and calling the respective method
		 LeadsPage leapag = new LeadsPage(driver);
		 leapag.clickOnAddIconImage();
		 
		 //create object of CreatingNewLeadPage and calling the respective method
		 CreatingNewLeadPage crealead = new CreatingNewLeadPage(driver);
		 crealead.clickOnSaveButton(lastName, companyName);
		 
		 //Verifying the lead information
		 String actualLeadInfo = crealead.getLeadInformationTitle();
		 if(actualLeadInfo.contains(expectedLeadInfo)) {
			 System.out.println("PASS : LEAD INFORMATION PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : LEAD INFORMATION PAGE SHOULD NOT BE DISPLAY");
		 }
		 
		 //create object of LeadInformationPage and calling the respective method
		 LeadInformationPage leadInfo = new LeadInformationPage(driver);
		 leadInfo.clickOnConvertLead(driver);		 
		//Verifying the convertLeadPageTitle information
		 String actualconvertLeadPageInfo = leadInfo.convertLeadPageTitle();
		 if(actualconvertLeadPageInfo.contains(expectedconvertLeadPageInfo)) {
			 System.out.println("PASS : CONVERT LEAD PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : CONVERT LEAD PAGE SHOULD NOT BE DISPLAY");
		 }
		 
		//create object of ConvertLeadPage and calling the respective method
		 ConvertLeadPage conLead = new ConvertLeadPage(driver);
		 conLead.convertLeadWithOpportunityAndContact(driver, opportunityName, date, mon, year);
		 
		//Verifying the organization Information Title information
		 String actualorganizationInformationPageInfo = conLead.organizationInformationTitle();
		 if(actualorganizationInformationPageInfo.contains(expectedorganizationInformationPageInfo)) {
			 System.out.println("PASS : ORGANIZATION INFORMATION PAGE SHOULD BE DISPLAY");
		 }else {
			 System.out.println("FAIL : ORGANIZATION INFORMATION PAGE SHOULD NOT BE DISPLAY");
		 }
		 Assert.assertEquals(actualorganizationInformationPageInfo.contains(expectedorganizationInformationPageInfo), true);
	}

}
