package practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.crm.autodesk.GenericUtility.ExcelUtility;
import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingHotelInGoibiboTest {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
	//getting the data from the property file
  	 FileUtility FU = new FileUtility();
  	 String browser = FU.getPropertyKeyValue("browser");
	           
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
  	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  	 driver.get("https://www.goibibo.com/hotels");
  	 
  	 driver.findElement(By.id("downshift-1-input")).click();
  	 driver.findElement(By.xpath("//p[text()='Dubai']")).click();
  	 driver.navigate().back();
  	 driver.findElement(By.xpath("//span[text()='Guests & Rooms']/../span[contains(@class,'SearchBlockUIstyles')]")).click();
  	 
  	 for(int i=1;i<=3;i++) {
  	 driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
  	 }
  	 driver.findElement(By.xpath("//span[text()='1']/following::h4[text()='Select'][1]")).click();
  	 driver.findElement(By.xpath("//li[text()='1']")).click();
  	
  	 driver.findElement(By.xpath("//span[text()='2']/following::h4[text()='Select'][1]")).click();
 	 driver.findElement(By.xpath("//li[text()='2']")).click();
 	
 	 driver.findElement(By.xpath("//span[text()='3']/following::h4[text()='Select'][1]")).click();
 	 driver.findElement(By.xpath("//li[text()='3']")).click();

 	 driver.findElement(By.xpath("//button[text()='Done']")).click();
 	 
 	 driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();	 
  	 
	}	
		
   }


