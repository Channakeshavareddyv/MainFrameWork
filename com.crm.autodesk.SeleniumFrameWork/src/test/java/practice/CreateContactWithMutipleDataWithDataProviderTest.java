package practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithMutipleDataWithDataProviderTest {
	
	@DataProvider()
	public Object[][] GetData() {
		Object[][] Crenditials = new Object[5][2];
		Crenditials[0][0]="channa";
		Crenditials[0][1]="9845099998";
		
		Crenditials[1][0]="willamson";
		Crenditials[1][1]="9845099999";
		
		Crenditials[2][0]="kane";
		Crenditials[2][1]="9845099990";
		
		Crenditials[3][0]="reddy";
		Crenditials[3][1]="9845099993";
		
		Crenditials[4][0]="keshava";
		Crenditials[4][1]="9845099994";
		
		return Crenditials;
		
	}
	@Test(dataProvider="GetData")
	public void CrenditialsTest(String name,String mobileNum) throws IOException {
		
		FileUtility FU = new FileUtility();
	   	 String browser = FU.getPropertyKeyValue("browser");
	   	 String url = FU.getPropertyKeyValue("url");
	   	 String username = FU.getPropertyKeyValue("username");
	   	 String password = FU.getPropertyKeyValue("password");
	   	 
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
	   	 driver.get(url);
	   	 
	   	 //creating the loginPage object and calling login method
		 LoginPage lp = new LoginPage(driver);
		 lp.login(username, password);
		 
		 driver.findElement(By.linkText("Contacts")).click();
		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 
		 driver.findElement(By.name("lastname")).sendKeys(name);
		 driver.findElement(By.id("mobile")).sendKeys(mobileNum);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 HomePage hp=new HomePage(driver);
		 hp.clickOnSignOutLink(driver);
		 driver.quit();
	}

}
