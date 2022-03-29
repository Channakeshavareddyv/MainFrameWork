package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this method will be convert lead
 * @author CHANNAKESHVA REDDY
 *
 */
public class ConvertLeadPage {
	//used to initialization
	public ConvertLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Deceleration of element
	@FindBy(name="Save")
	private WebElement SaveButton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationInformationTitle;
	
	@FindBy(xpath="//b[text()='Organization']/preceding-sibling::input[@type='checkbox']")
	private WebElement organizationcheckboxButton;
	
	@FindBy(xpath="//b[text()='Opportunity']/preceding-sibling::input[@type='checkbox']")
	private WebElement opportunitycheckboxButton;
	
	@FindBy(id="potentialname")
	private WebElement opportunityNameTextField;
	
	@FindBy(name="closingdate")
	private WebElement closingDateTextField;
	
	@FindBy(xpath="//img[@src='themes/images/miniCalendar.gif']")
	private WebElement closeDateIcon;

	//providing getters
	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public WebElement getOrganizationInformationTitle() {
		return organizationInformationTitle;
	}	

	public WebElement getOrganizationcheckboxButton() {
		return organizationcheckboxButton;
	}

	public WebElement getOpportunitycheckboxButton() {
		return opportunitycheckboxButton;
	}

	
	public WebElement getOpportunityNameTextField() {
		return opportunityNameTextField;
	}

	public WebElement getClosingDateTextField() {
		return closingDateTextField;
	}	

	public WebElement getCloseDateIcon() {
		return closeDateIcon;
	}

	//using business logic
	/**
	 * this method will click on save button
	 */
	public void clickOnConvertLeadSaveButton() {
		SaveButton.click();		
	}
	/**
	 * this will convert Lead With Opportunity And Contact
	 * @param driver
	 * @param opportunityName
	 * @param date
	 * @param mon
	 * @param year
	 */
	public void convertLeadWithOpportunityAndContact(WebDriver driver,String opportunityName,String date,String mon,String year) {
		organizationcheckboxButton.click();
		opportunitycheckboxButton.click();
		opportunityNameTextField.sendKeys(opportunityName);
		closeDateIcon.click();
		driver.findElement(By.xpath("//td[text()='"+mon+", "+year+"']/following::td[text()='"+date+"']")).click();
		SaveButton.click();
	}
	/**
	 * this method will return organization Information Title
	 * @return
	 */
	public String organizationInformationTitle() {
		return organizationInformationTitle.getText();
	}	
}
