
package practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tester1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, AWTException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		
		robo.keyPress(KeyEvent.VK_P);
		robo.keyRelease(KeyEvent.VK_P);
		Thread.sleep(1000);
		robo.keyPress(KeyEvent.VK_P);
		robo.keyPress(KeyEvent.VK_P);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

}
