package sdet31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class ClickOnParticularDate1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility WU=new WebDriverUtility();
		WU.waitForPageToLoad(driver);
		driver.get("https://www.cleartrip.com");
		
		driver.findElement(By.xpath("//h4[text()='Depart on']/following::button[contains(@class,\"flex flex-middle flex-between\")]")).click();
		driver.findElement(By.xpath("//div[text()='April 2022']/following::div[text()='23']")).click();

	}

}
