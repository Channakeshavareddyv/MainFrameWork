package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDateTest {
     public static void main(String[] args) throws IOException, InterruptedException {
    	 
    	 FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\CommonData\\crenditials.properties");
    	 Properties properties = new Properties();
    	 properties.load(fin);
    	 String browser = properties.getProperty("browser");
    	 String url = properties.getProperty("url");
    	 String username = properties.getProperty("username");
    	 String password = properties.getProperty("password");
    	 System.out.println(browser);
    	 System.out.println(url);
    	 System.out.println(username);
    	 System.out.println(password);
    	 
    	 JavaUtility JU = new JavaUtility();
    	 String actualDate = JU.getSystemDateWithFormate();
    	 
			/*
			 * LocalDateTime DateAndTime = LocalDateTime.now(); String gettingDate =
			 * DateAndTime.toString(); String actualDate = gettingDate.split("T")[0];
			 * System.out.println(actualDate);
			 */
    	 
    	 
    	 FileInputStream fis = new FileInputStream(".\\src/test/resources/TestData/testData.xlsx");
  	     Workbook workbook = WorkbookFactory.create(fis);
  	     Sheet sheet = workbook.getSheet("Sheet2");
  	   
  	     int rowcount = sheet.getPhysicalNumberOfRows();
  	     int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
  	   
  	    for(int i=0;i<=rowcount-1;i++) {
  		   for(int j=0;j<=colcount-1;j++) {
  			  System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
  		   }
  		   System.out.println();
  	   }
  	   System.out.println("===============================================");
  	   String LastNameData = sheet.getRow(1).getCell(1).getStringCellValue();
  	   System.out.println(LastNameData);
    	 
    	          
    	 WebDriver driver=null;
    	 
    	 if(browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    	    driver = new ChromeDriver();
    	 
    	 }else if(browser.equalsIgnoreCase("firefox")) {
    		 WebDriverManager.firefoxdriver().setup();
    		 driver = new FirefoxDriver();
    	 }
    	 else if(browser.equalsIgnoreCase("opera")) {
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
    	 driver.get(url);
    	 driver.findElement(By.name("user_name")).sendKeys(username);
    	 driver.findElement(By.name("user_password")).sendKeys(password);
    	 driver.findElement(By.id("submitButton")).click();
    	 
    	 driver.findElement(By.linkText("Contacts")).click();
    	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    	 
    	 Random random =new Random();
    	 int randomNum = random.nextInt(1000);
    	 String lastNameData = LastNameData+randomNum;
    	 Select select = new Select(driver.findElement(By.name("salutationtype")));
    	 String respect = sheet.getRow(1).getCell(3).getStringCellValue();
    	 select.selectByValue(respect);
    	 String firstname = sheet.getRow(1).getCell(0).getStringCellValue();
    	 driver.findElement(By.name("firstname")).sendKeys(firstname);
    	 driver.findElement(By.name("lastname")).sendKeys(lastNameData);
    	 
    	 WebElement SupportStartDate = driver.findElement(By.name("support_start_date"));
    	 SupportStartDate.clear();
    	 SupportStartDate.sendKeys(actualDate);
    	   
    	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	 
    	 WebElement header = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
    	 if(header.getText().contains(lastNameData)) {
    		 System.out.println("PASS : CONTACT IS CREATED WITH DATE");
    	 }
    	 else {
    		 System.out.println("FAIL : CONTACT IS NOT CREATED WITH DATE");
    	 }
    	 WebDriverWait wait = new WebDriverWait(driver,10);
    	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))));
    	 
    	 Actions action = new Actions(driver);
 		 action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
 		 driver.findElement(By.linkText("Sign Out")).click();
    	 driver.quit();
	}
	
}


