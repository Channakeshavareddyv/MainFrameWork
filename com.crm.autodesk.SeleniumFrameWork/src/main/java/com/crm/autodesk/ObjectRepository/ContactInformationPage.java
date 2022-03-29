package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class will give contact InformationPage	
 * @author CHANNAKESHVA REDDY
 *
 */
public class ContactInformationPage {
	//Initialization of web elements
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Deceleration of web elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInformation;
    
	//providing getters methods
	public WebElement getContactInformation() {
		return contactInformation;
	}
	//Creating Business library
	/**
	 * this method will return contact Information
	 * @return
	 */
	public String verfiyContactInformation() {
		
		return contactInformation.getText();
	}

}
