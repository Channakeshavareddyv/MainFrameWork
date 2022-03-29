package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class will give Product InformationPage	
 * @author CHANNAKESHVA REDDY
 *
 */
public class ProductInformationPage {
	
	//Initialization of web elements
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Deceleration of web elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ProductInformation;
    
	//providing getters methods
	public WebElement getOrganizationInformation() {
		return ProductInformation;
	}
	//Creating Business library
	/**
	 * this method will return Product Information
	 * @return
	 */
	public String verfiyProductInformation() {
		
	   return ProductInformation.getText();
	}

}
