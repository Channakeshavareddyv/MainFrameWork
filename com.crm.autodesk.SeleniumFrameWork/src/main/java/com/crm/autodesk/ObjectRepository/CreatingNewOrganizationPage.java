package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;
/**
 * this class will used to Creating New Organization Page
 * @author CHANNAKESHVA REDDY
 *
 */
public class CreatingNewOrganizationPage {
	
	//Initialization of web elements
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Deceleration of web elements
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSaveButton;
    
	//providing getters methods
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryTextField() {
		return industryTextField;
	}
	//Creating Business library
	/**
	 * this method will creating Organization with Organization Name
	 * @param organNameData
	 */
	public void creatingOrganizationWithOrganizationName(String organNameData) {
		organizationNameTextField.sendKeys(organNameData);
		clickOnSaveButton.click();
	}
	/**
	 * this method will creating Organization With Industry
	 * @param organNameData
	 * @param industryData
	 */
	public void creatingOrganizationWithIndustry(String organNameData,String industryData) {
		
		organizationNameTextField.sendKeys(organNameData);
		WebDriverUtility WU=new WebDriverUtility();
        WU.select(industryTextField, industryData);
        clickOnSaveButton.click();
	}

}
