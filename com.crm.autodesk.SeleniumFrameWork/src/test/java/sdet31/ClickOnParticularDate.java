package sdet31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class ClickOnParticularDate {

	public static void main(String[] args) {
		
		String Date = "22";
		String month = "May";
		String year = "2022";
		System.out.println(month+" "+year);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility WU=new WebDriverUtility();
		WU.waitForPageToLoad(driver);
		driver.get("https://www.makemytrip.com");
		
		WU.mouseOverOnOffsetAndClick(driver, 10, 10);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		for(;;) {
		try {
		driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Date+"']")).click();
		System.out.println("PASS : DATE IS SELECTED");
		break;
		}catch(Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	  }
	}

}
