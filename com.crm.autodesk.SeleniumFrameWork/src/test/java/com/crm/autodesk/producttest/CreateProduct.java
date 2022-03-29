package com.crm.autodesk.producttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

import com.crm.autodesk.GenericUtility.ExcelUtility;
import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.ObjectRepository.CreatingNewProductPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.ProductInformationPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {
     public static void main(String[] args) throws IOException, InterruptedException {
    	 
    	 FileUtility FU = new FileUtility();
    	 String BROWSER = FU.getPropertyKeyValue("browser");
    	 String URL = FU.getPropertyKeyValue("url");
    	 String USERNAME = FU.getPropertyKeyValue("username");
    	 String PASSWORD = FU.getPropertyKeyValue("password");
    	 
    	 JavaUtility JU = new JavaUtility();
    	 int randomNum = JU.getRanDomNum();
    	 
    	 ExcelUtility EU = new ExcelUtility();
    	 String PRODUCTNAME = EU.getDataFromExcel("Sheet5",1 , 1)+"_"+randomNum;
  	      	          
    	 WebDriver driver=null;
    	 
    	 if(BROWSER.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    	    driver = new ChromeDriver();
    	 
    	 }else if(BROWSER.equalsIgnoreCase("firefox")) {
    		 WebDriverManager.firefoxdriver().setup();
    		 driver = new FirefoxDriver();
    	 }
    	 else if(BROWSER.equalsIgnoreCase("opera")) {
    		 WebDriverManager.operadriver().setup();
    		 driver = new OperaDriver();
    	 }
    	 else {
    		 System.out.println("==IT SUPPORT ONLY TWO BROWSER==");
    	 }
    	 
    	 driver.manage().window().maximize();
    	 WebDriverUtility WU = new WebDriverUtility();
    	 WU.waitForPageToLoad(driver);
    	 //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	 driver.get(URL);
    	 
    	 LoginPage lp=new LoginPage(driver);
    	 lp.login(USERNAME, PASSWORD);
    	 
    	 HomePage hp=new HomePage(driver);
    	 hp.clickOnProductsLink();
    	 
    	 ProductsPage propage=new ProductsPage(driver);
    	 propage.clickOnAddIconImage();
    	 
    	 CreatingNewProductPage creaNewPro=new CreatingNewProductPage(driver);
         creaNewPro.createProduct(PRODUCTNAME);
    	 
         ProductInformationPage proinfo=new ProductInformationPage(driver);
         String ACTUALPRODUCTNAME = proinfo.verfiyProductInformation();
    	 
    	 if(ACTUALPRODUCTNAME.contains(PRODUCTNAME)) {
    		 System.out.println("PASS : PRODUCT IS CREATED");
    	 }
    	 else {
    		 System.out.println("PASS : PRODUCT IS NOT CREATED");
    	 }
    	 hp.clickOnSignOutLink(driver);
 		 driver.quit();
		} 
    	   	 
}

