package sdet31;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class SelectTodayDate {

	public static void main(String[] args) throws InterruptedException {
		
		LocalDateTime dateATime = LocalDateTime.now();
		String datetime = dateATime.toString();
		int date = dateATime.getDayOfMonth();
		String mon = dateATime.getMonth().toString();
		int year = dateATime.getYear();
		String act = mon.subSequence(0, 1)+mon.substring(1).toLowerCase();
		String actualMonAndYear = act+" "+year;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		
		WebDriverUtility WU=new WebDriverUtility();
		WU.mouseOverOnOffsetAndClick(driver, 10, 10);
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//p[text()='Hyderabad, India']")).click();
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//p[text()='Dubai, United Arab Emirates']")).click();
		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		driver.findElement(By.xpath("//div[text()='"+actualMonAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		for (WebElement ele : names) {
			System.out.println(ele.getText());
		}

	}

}
