package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this will used to Create Duplicating Lead 
 * @author CHANNAKESHVA REDDY
 *
 */
public class DuplicatingLeadPage {
	
	//Initialization of web elements
	public DuplicatingLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Deceleration of web elements
	@FindBy(name="lastname")
	private WebElement lastNameTextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//providing getters methods
	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	//using business logic
	/**
	 * this will used creating Duplicating Lead and click on save button
	 * @param DuplicateName
	 */
	public void creatingDuplicatingLead(String DuplicateName) {
		lastNameTextfield.sendKeys(DuplicateName);
		saveButton.click();
	}

}
