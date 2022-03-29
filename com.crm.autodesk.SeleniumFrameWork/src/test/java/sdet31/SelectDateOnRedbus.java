package sdet31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class SelectDateOnRedbus {

	public static void main(String[] args) {
		
		String date="24";
		String mon="Oct";
		String year="2023";
		System.out.println(mon+" "+year);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility WU=new WebDriverUtility();
		WU.waitForPageToLoad(driver);
		driver.get("https://www.redbus.in");
		
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		for(;;) {
		try {
		driver.findElement(By.xpath("//td[text()='"+mon+" "+year+"']/ancestor::table[@class='rb-monthTable first last']/descendant::td[text()='"+date+"']")).click();
		String ActualDate = driver.findElement(By.id("onward_cal")).getAttribute("data-caleng");
		System.out.println(ActualDate+" : IS SELECTED");
		break;
		}catch(Exception e) {
			driver.findElement(By.xpath("//td[@class='next']")).click();
		}
	   }
	}

}
