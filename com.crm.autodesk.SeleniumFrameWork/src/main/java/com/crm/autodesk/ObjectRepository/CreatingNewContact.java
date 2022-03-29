package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;
/**
 * this class will used to Creating New Contact
 * @author CHANNAKESHVA REDDY
 *
 */
public class CreatingNewContact {
	
	//Initialization of web elements
	public CreatingNewContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Deceleration of web elements
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='account_name']/parent::td[@class='dvtCellInfo']/child::img[@src='themes/softed/images/select.gif']")
	private WebElement AddOrganizationNameIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSaveButton;
	
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	//providing getters methods
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getAddOrganizationNameIcon() {
		return AddOrganizationNameIcon;
	}
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	// using business logic
	/**
	 * this method will click on create Contact With Contact Name
	 * @param LastNameData
	 */
	public void createContactWithContactName(String LastNameData) {
		lastNameTextField.sendKeys(LastNameData);
		clickOnSaveButton.click();
	}
	/**
	 * this method will used create Contact With Organization Name
	 * @param driver
	 * @param LastNameData
	 * @param ORGANISATIONNAME
	 */
	public void createContactWithOrganizationName(WebDriver driver,String LastNameData,String ORGANISATIONNAME) {
		lastNameTextField.sendKeys(LastNameData);
		AddOrganizationNameIcon.click();
		WebDriverUtility WU = new WebDriverUtility();
		WU.switchToWindow(driver, "Accounts");
		searchTextField.sendKeys(ORGANISATIONNAME);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+ORGANISATIONNAME+"']")).click();
		WU.switchToWindow(driver, "Contacts");
		clickOnSaveButton.click();
		
	}

}
