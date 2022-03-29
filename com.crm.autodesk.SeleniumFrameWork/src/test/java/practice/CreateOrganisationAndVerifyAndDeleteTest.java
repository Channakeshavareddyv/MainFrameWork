package practice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateOrganisationAndVerifyAndDeleteTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
   	 
   	 //getting the data from the property file
   	 FileUtility FU = new FileUtility();
   	 String browser = FU.getPropertyKeyValue("browser");
   	 String url = FU.getPropertyKeyValue("url");
   	 String username = FU.getPropertyKeyValue("username");
   	 String password = FU.getPropertyKeyValue("password");

   	//getting the data from the Excel file
   	 ExcelUtility EU = new ExcelUtility();
   	 JavaUtility JU = new JavaUtility();
   	 String organNameData = EU.getDataFromExcel("Sheet1", 2, 0)+"_"+JU.getRanDomNum();
		
 	     System.out.println(organNameData);
 	           
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
		 
		 //creating the HomePage object and calling respective method
		 HomePage hp = new HomePage(driver);
		 hp.clickOnOrganizationLink();
		 
		//creating the OrganizationsPage object and calling respective method
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		JavaUtility ju=new JavaUtility();
		orgPage.clickOnAddIconImage();
		String orgName = "Shakti industries"+ju.getRanDomNum();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Organizations")).click();
	
		for(;;) {
			List<WebElement> ActualorganNames = driver.findElements(By.xpath("//a[contains(@href,'index.php?module=Accounts&parenttab=Marketing&action=DetailView&record')]"));
			for (WebElement ele : ActualorganNames) {
				System.out.println(ele.getText());
			  }
			
			try {
				driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
				Thread.sleep(3000);
			}catch(Exception e)	{
				//if(ActualorganNames.equals(orgName)) {
					driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[3]")).click();
					driver.findElement(By.name("Delete")).click();
					Thread.sleep(5000);
					WebDriverUtility webU=new WebDriverUtility();
					webU.switchToAlertWindowAndAccpect(driver);
				//}
				break;
			}
		}
	}
}
