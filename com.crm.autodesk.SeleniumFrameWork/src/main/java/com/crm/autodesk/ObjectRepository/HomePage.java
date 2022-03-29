package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;
/**
 * This Pom class used perform action Home page
 * @author CHANNAKESHVA REDDY
 *
 */
public class HomePage {
	
	//Deceleration of web elements
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement homePageTitle;
	
	//Initialization of web elements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
     //providing getters methods
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}
	
	public WebElement getSignOutIcon() {
		return signOutIcon;
	}

    public WebElement getSignOutLink() {
		return signOutLink;
	}
    
	public WebElement getHomePageTitle() {
		return homePageTitle;
	}

	// using business logic
	/**
	 * this method will click on organizationsLink
	 */
	public void clickOnOrganizationLink() {
		
		organizationsLink.click();
	}
	/**
	 * this method will click on contactLink
	 */
	public void clickOnContactLink() {
		contactsLink.click();
	}
	// using business logic
		/**
		 * this method will click on product Link
		 */
	public void clickOnProductsLink() {
			
	    productsLink.click();
	}
	// using business logic
			/**
			 * this method will click on leads Link
			 */
	public void clickOnLeadsLink() {
				
		leadsLink.click();
	}
	////Creating Business library
    /**
     * this method will sign out
     * @param driver
     */
	public void clickOnSignOutLink(WebDriver driver) {
    	
        WebDriverUtility WU=new WebDriverUtility();
        WU.mouseOverOnElement(driver,signOutIcon);
        signOutLink.click();
    }
	/**
	 * this method will return Home Title
	 * @param driver
	 * @return
	 */
	public String getHomeTitle(WebDriver driver) {
		return homePageTitle.getText();
	}

}
