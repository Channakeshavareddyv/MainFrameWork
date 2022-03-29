package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class will used to Creating New Product 
 * @author CHANNAKESHVA REDDY
 *
 */
public class CreatingNewProductPage {
	
	//Initialization of web elements
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Deceleration of web elements
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSaveButton;
	
	//providing getters methods
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}
		
	public WebElement getClickOnSaveButton() {
		return clickOnSaveButton;
	}

    //using business logic create Product
	/**
	 * this method will 
	 * @param PRODUCTNAME
	 */
	public void createProduct(String PRODUCTNAME) {
		
		productNameTextField.sendKeys(PRODUCTNAME);
		clickOnSaveButton.click();
	}
	

}
