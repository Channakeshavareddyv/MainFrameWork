package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Destination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.mysql.cj.util.Util;

/**
 * its contains WebDriver Specific reusable actions
 * @author CHANNAKESHVA REDDY
 *
 */
public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM[HTML-document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * wait for page to load before identifying any Asynchronized java script element in DOM[HTML-document]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);		
	}
	/**
	 * used to wait for element to be clickable in GUI,& check for specific element for every 500 milli seconds
	 * @param driver 
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to be clickable in GUI,& check for specific element for every 500 milli seconds
	 * @param driver 
	 * @param element
	 * @param pollingTime in the form second
	 * @throws InterruptedException 
	 * @throws Throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws InterruptedException {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * used to switch to alert window & click on OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to alert window & click on Cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to Frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to switch to Frame window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to select the value from the dropDown based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDown based on value/option
	 * @param driver
	 * @param value
	 */
	public void select(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specific element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * used to right click on right click
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * used to take webPageScreenshot
	 * @param driver
	 * @param screenshotname 
	 * @throws IOException 
	 */
	public String takeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = LocalDateTime.now().toString().replace(":","-");
		File dest =new File("./ErrorShots/"+screenshotName+timestamp+".PNG");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}
	/**
	 * pass enter key appertain in to browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * used to perform javascript actions on target element
	 * @param driver
	 * @param javascript
	 */
	public void executeJavaScript(WebDriver driver,String javaScript) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(javaScript, null);
	}
	/**
	 * used create a custom wait 
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20){
			try {
				element.click();
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * used to take a Double click of Target WebElement
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement Element){
		Actions actions = new Actions(driver);
		actions.doubleClick(Element);
	}
	/**
	 * it is used to Drag and Drop the Target WebElement
	 * @param driver
	 * @param sourceElement
	 * @param targetElement
	 */
	public void dragAndDrop(WebDriver driver,WebElement sourceElement,WebElement targetElement){
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement,targetElement);
	}
	/**
	 * used to place mouse cursor on offSet X,Y
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnOffsetAndClick(WebDriver driver,int XOffset,int YOffset) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(XOffset, YOffset).click().perform();
	}
		
}
