package practice;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampignTest {
     public static void main(String[] args) throws IOException, InterruptedException {
    	 
    	 FileUtility FU = new FileUtility();
    	 String BROWSER=FU.getPropertyKeyValue("browser");
    	 String URL = FU.getPropertyKeyValue("url");
    	 String USERNAME = FU.getPropertyKeyValue("username");
    	 String PASSWORD = FU.getPropertyKeyValue("password");
    	              
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
    	 driver.get(URL);
    	 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    	 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    	 driver.findElement(By.id("submitButton")).click();
    	 
    	 JavaUtility JU = new JavaUtility();
    	 int randomNum = JU.getRanDomNum();
    	 ExcelUtility EU = new ExcelUtility();
    	 String PRODUCTNAME = EU.getDataFromExcel("Sheet5",2,1)+"_"+randomNum;
    	 
    	 driver.findElement(By.linkText("Products")).click();
    	 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
    	 
    	 driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
    	 
    	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	 
    	 WebElement header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
    	 if(header.getText().contains(PRODUCTNAME)) {
    		 System.out.println("PASS : PRODUCT IS CREATED");
    	 }
    	 else {
    		 System.out.println("PASS : PRODUCT IS NOT CREATED");
    	 }
    	 
    	 WU.mouseOverOnElement(driver, driver.findElement(By.linkText("More")));
    	 
    	 driver.findElement(By.name("Campaigns")).click();
    	 
    	 driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
    	
    	 String CampaignNameData = EU.getDataFromExcel("Sheet5", 2, 0);
    	 
    	 String CampaignName= CampaignNameData+"_"+randomNum;
    	 driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
    	 
    	 driver.findElement(By.xpath("//input[@name='product_name']/..//img[@title='Select']")).click();
    	 
    	 WU.switchToWindow(driver, "Products");
   
    	 driver.findElement(By.id("search_txt")).sendKeys(PRODUCTNAME);
    	 driver.findElement(By.name("search")).click();
    	 
    	 driver.findElement(By.xpath("//a[text()='"+PRODUCTNAME+"']")).click();
    	 
    	 WU.switchToWindow(driver,"Campaigns");
    
    	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	 
    	 WebElement verfiy = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
    	 if(verfiy.getText().contains(CampaignName)) {
    		 System.out.println("PASS : CAMPIGN CREATED WITH PRODUCT");
    	 }
    	 else {
    		 System.out.println("FAIL : CAMPIGN NOT CREATED WITH PRODUCT");
    	 }
    	 WU.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
         driver.findElement(By.linkText("Sign Out")).click();
         driver.quit();
		} 
}

