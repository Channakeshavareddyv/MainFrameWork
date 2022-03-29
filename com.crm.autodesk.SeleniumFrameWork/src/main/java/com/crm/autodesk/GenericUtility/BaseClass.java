package com.crm.autodesk.GenericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * it class contains common methods
 * @author CHANNAKESHVA REDDY
 *
 */
public class BaseClass {
	
	public WebDriver driver=null;
	public FileUtility fu=new FileUtility();
	public ExcelUtility EU = new ExcelUtility();
	public JavaUtility JU = new JavaUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
	public void bs() {
		System.out.println("Database connection are Done");
	}
	@BeforeTest(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
	public void ts() {
		System.out.println("Executing the parallel execution");
	}
	//@org.testng.annotations.Parameters("browsername")
	@BeforeClass(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
	public void bc() throws IOException{
		String browser = fu.getPropertyKeyValue("browser");
		String url = fu.getPropertyKeyValue("url");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
		}else if (browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
            System.out.println("it support for only two browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		sDriver=driver;
		
		}
		@BeforeMethod(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
		public void bm() throws IOException {
			String username = fu.getPropertyKeyValue("username");
			String password = fu.getPropertyKeyValue("password");
			LoginPage lp=new LoginPage(driver);
			lp.login(username, password);
		}
		@AfterMethod(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
		public void am() {
			HomePage hp=new HomePage(driver);
			hp.clickOnSignOutLink(driver);			
		}
		@AfterClass(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
		public void ac() {
			driver.quit();
		}
		@AfterTest(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
		public void at() {
			System.out.println("close the parllel Execution");
		}
		@AfterSuite(groups= {"integrationTest","smokeTest","regressionTest","functioanlTest","systemTest"})
		public void as() {
			System.out.println("Close the database connection");
		}

}
