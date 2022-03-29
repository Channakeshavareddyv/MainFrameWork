package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;
/**
 * this class will click on convert lead
 * @author CHANNAKESHVA REDDY
 *
 */
public class LeadInformationPage {
	//used to initialization
	public LeadInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Deceleration of element
	@FindBy(linkText="Convert Lead")
	private WebElement convertLeadLink;
	
	@FindBy(xpath="//img[@src='themes/images/Leads.gif']/parent::td[@class='genHeaderSmall']")
	private WebElement convertLeadPageTitle;
	
	@FindBy(xpath="//input[@title='Duplicate [Alt+U]']")
	private WebElement duplicateButton;
	
	@FindBy(name="Delete")
	private WebElement deleteButton;
	
	//providing getters
	public WebElement getConvertLeadPageTitle() {
		return convertLeadPageTitle;
	}

	public WebElement getConvertLeadLink() {
		return convertLeadLink;
	}
	
	public WebElement getDuplicateButton() {
		return duplicateButton;
	}
    
	public WebElement getDeleteButton() {
		return deleteButton;
	}

	//using business logic
	/**
	 * this method will click on Convert Lead
	 * @param driver
	 */
	public void clickOnConvertLead(WebDriver driver) {
		
		WebDriverUtility WU=new WebDriverUtility();
		WU.mouseOverOnElement(driver, convertLeadLink);
		convertLeadLink.click();		
	}
	/**
	 * this method will return convert LeadPage Titles
	 * @return
	 */
	public String convertLeadPageTitle() {
		return convertLeadPageTitle.getText();
	}
	/**
	 * this method will click 
	 * @throws InterruptedException On Duplicate Button
	 */
	public void clickOnDuplicateButton() {
		duplicateButton.click();
	}
	/**
	 * this method will delete Duplicate Lead 
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void deleteDuplicateLead(WebDriver driver) throws InterruptedException {
		deleteButton.click();
		WebDriverUtility WU=new WebDriverUtility();
		WU.switchToAlertWindowAndAccpect(driver);
	}

}
