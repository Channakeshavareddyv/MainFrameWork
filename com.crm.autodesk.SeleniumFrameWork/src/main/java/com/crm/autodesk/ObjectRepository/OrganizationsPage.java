package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class used perform action OrganizationsPage
 * @author CHANNAKESHVA REDDY
 *
 */
public class OrganizationsPage{
	
	//Deceleration of web elements
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement addIconImage;
	
	//Initialization of web elements
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//providing getters methods
	public WebElement getAddIconImage() {
			return addIconImage;
	}
	
	//Creating Business library
	 /**
	  * this will click on add icon image   
	  */
	 public void clickOnAddIconImage() {
	    	addIconImage.click();
	 }

}
