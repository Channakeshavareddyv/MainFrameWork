package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class used to create new lead 
 * @author CHANNAKESHVA REDDY
 *
 */
public class CreatingNewLeadPage {
	
	//used to initialization
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Deceleration of elements
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name="company")
	private WebElement companyNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerTitle;
	
	//providing getters
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
		
    public WebElement getHeaderTitle() {
		return headerTitle;
	}

	//using business logic
	/**
	 * this method is used to click on save button
	 * @param lastName
	 * @param companyName
	 */
	public void clickOnSaveButton(String lastName,String companyName) {
		
		lastNameTextField.sendKeys(lastName);
		companyNameTextField.sendKeys(companyName);
		saveButton.click();
	}
	/**
	 * this method will return Lead Information Title
	 * @return
	 */
	public String getLeadInformationTitle() {
		return headerTitle.getText();
	}

}
