package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this pom class for Login Page
 * @author CHANNAKESHVA REDDY
 *
 */
public class LoginPage {
	
	//Declerection of web elements
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//creating constructor for loginpage
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
    //providing getters methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;

	}
	//Creating Business library
	/**
	 * this method will login to application
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) {
	userNameTextField.sendKeys(username);
	passwordTextField.sendKeys(password);
	loginButton.click();
		
   }
	/**
	 * this method will return Login Title
	 * @param driver
	 * @return
	 */
	public String getLoginTitle(WebDriver driver) {
		return driver.getTitle();
	}
}
