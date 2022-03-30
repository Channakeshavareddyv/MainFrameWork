package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.IPathConstant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToCRMTest {
	
         @Test	
         public void test() throws IOException {
    	 
    	 FileInputStream fin = new FileInputStream(IPathConstant.FILE_PATH);
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
    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	 driver.get(url);
    	 driver.findElement(By.name("user_name")).sendKeys(username);
    	 driver.findElement(By.name("user_password")).sendKeys(password);
    	 driver.findElement(By.id("submitButton")).click();
    	 driver.quit();
    	 
	}
	
}
