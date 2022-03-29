package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

/**
 * this class used perform action leads Page
 * @author CHANNAKESHVA REDDY
 *
 */
public class LeadsPage{
	
		//Deceleration of web elements
		@FindBy(xpath="//img[@title='Create Lead...']")
		private WebElement addIconImage;
		
		@FindBy(name="search_text")
		private WebElement searchTextField;
		
		@FindBy(id="bas_searchfield")
		private WebElement inTextField;
		
		@FindBy(name="submit")
		private WebElement searchNowButton;
		
		@FindBy(xpath="//span[@class='genHeaderSmall']")
		private WebElement noLeadFound;
		
		//Initialization of web elements
		public LeadsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//providing getters methods
		public WebElement getAddIconImage() {
				return addIconImage;
		}
		
		public WebElement getSearchTextField() {
			return searchTextField;
		}
		public WebElement getInTextField() {
			return inTextField;
		}
		public WebElement getSearchNowButton() {
			return searchNowButton;
		}
		
		public WebElement getNoLeadFound() {
			return noLeadFound;
		}
		////Creating Business library
		 /**
		  * this will click on add icon image   
		  */
		 public void clickOnAddIconImage() {
		    	addIconImage.click();
		 }
		 /**
		  * this method will used search For Last Name And Click
		  * @param driver
		  * @param lastName
		  * @param suggestions
		  */
		 public void searchForLastNameAndClick(WebDriver driver, String lastName,String suggestions) {
			 searchTextField.sendKeys(lastName);
			 WebDriverUtility WU=new WebDriverUtility();
			 WU.select(inTextField,suggestions);
			 searchNowButton.click();
			 driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
		 }
		 /**
		  * this method will used search For Duplicate LastName And Click
		  * @param driver
		  * @param lastName
		  * @param DuplicateName
		  * @param suggestions
		  */
		 public void searchForDuplicateLastNameAndClick(WebDriver driver,  String lastName ,String DuplicateName,String suggestions) {
			 searchTextField.sendKeys(DuplicateName);
			 WebDriverUtility WU=new WebDriverUtility();
			 WU.select(inTextField,suggestions);
			 searchNowButton.click();
			 driver.findElement(By.xpath("//a[text()='"+lastName+DuplicateName+"']")).click();
		 }
		 public String noLeadFound(WebDriver driver,String DuplicateName,String suggestions) {
			 searchTextField.sendKeys(DuplicateName);
			 WebDriverUtility WU=new WebDriverUtility();
			 WU.select(inTextField,suggestions);
			 searchNowButton.click();
			 return noLeadFound.getText();
		 }
	 
}
