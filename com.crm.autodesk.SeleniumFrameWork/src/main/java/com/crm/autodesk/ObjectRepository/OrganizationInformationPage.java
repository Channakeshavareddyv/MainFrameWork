package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class will give Organization InformationPage	
 * @author CHANNAKESHVA REDDY
 *
 */
public class OrganizationInformationPage {
	//Initialization of web elements
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Deceleration of web elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrganizationInformation;
    
	//providing getters methods
	public WebElement getOrganizationInformation() {
		return OrganizationInformation;
	}
	//Creating Business library
	/**
	 * this method will return Organization Information
	 * @return
	 */
	public String verfiyOrganizationInformation() {
		
		return OrganizationInformation.getText();
	}

}
