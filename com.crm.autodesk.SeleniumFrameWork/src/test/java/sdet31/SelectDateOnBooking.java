package sdet31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class SelectDateOnBooking {

	public static void main(String[] args) {
		
		String date="24";
		String mon="Oct";
		String year="2023";
		System.out.println(mon+" "+year);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility WU=new WebDriverUtility();
		WU.waitForPageToLoad(driver);
		driver.get("https://www.booking.com");
		
		driver.findElement(By.cssSelector("svg[class='bk-icon -experiments-calendar sb-date-picker_icon-svg']")).click();
		for(;;){
		try {
		driver.findElement(By.xpath("//div[text()='"+mon+" "+year+"']/parent::div[@class='bui-calendar__wrapper']/descendant::span[text()='"+date+"']")).click();
		String actualDate = driver.findElement(By.xpath("//td[@class='bui-calendar__date']")).getAttribute("aria-label");
		System.out.println(actualDate+" : IS SELECTED");
		break;
		}
		catch(Exception e) {
         driver.findElement(By.xpath("//div[@data-bui-ref='calendar-next']")).click();
		}
	  }

	}

}
