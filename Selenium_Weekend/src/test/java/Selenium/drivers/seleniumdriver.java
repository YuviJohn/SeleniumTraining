package Selenium.drivers;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Selenium.utilities.utility;

public class seleniumdriver {

	
	
	public static By getByType(WebDriver driver, String locator, String locatorType) {
	
		By result = null;
		
		if(locatorType.equals("id")) {
			
			result = By.id(locator);
			return result;
		}else if(locatorType.equals("name")) {
			
			result = By.name(locator);
			return result;
		}else if(locatorType.equals("class")) {
			
			result = By.className(locator);
			return result;
		}else if(locatorType.equals("xpath")) {
			
			result = By.xpath(locator);
			return result;
		}else if(locatorType.equals("tagname")) {
			
			result = By.tagName(locator);
			return result;
		}else if(locatorType.equals("css_selector")) {
			
			result = By.cssSelector(locator);
			return result;
		}
		
		return result;
		
	}
	
	
	public static WebElement findElement(WebDriver driver, String locator, String locatorType) {
		
		By res = getByType(driver, locator, locatorType);
		
		
		WebElement element = driver.findElement(res);
		explicitWait(driver, 20, element);
		if(element!= null) {
			utility.generateLogReportInfo("Element is identified with Locator: " + locator + "with locator Type: " + locatorType);
		}
		else {
			utility.generateLogReportError("Element is not able to identified with Locator: " + locator + "with locator Type: " + locatorType);
			takeScreenshot(driver);
		}
		return element;
	}
	
	public static void sendkeys(WebDriver driver, String locator, String locatorType, String Value) {
		
		
		
		WebElement ele = findElement(driver, locator, locatorType);
		
		if(ele!=null) {
			utility.generateLogReportInfo("Element is identified with Locator: " + locator + "with locator Type: " + locatorType + " the value is passed to the field");
			ele.sendKeys(Value);
		}else {
			utility.generateLogReportError("Element is not able to identified with Locator: " + locator + "with locator Type: " + locatorType + "the value is cannot be passed to the field\"");
			takeScreenshot(driver);
		}
		
		
		
	}
	
	public static void click(WebDriver driver, String locator, String locatorType) {
		
		WebElement ele = findElement(driver, locator, locatorType);
		ele.sendKeys(Keys.RETURN);
		
		
	}
	
	public static void validateElementDisplayed(WebDriver driver, String locator, String locatorType, String message) {
		WebElement ele = findElement(driver, locator, locatorType);
		if(ele.isDisplayed()) {
			utility.generateLogReportInfo("Element is identified with Locator: " + locator + "with locator Type: " + locatorType + " the Element is Displayed");
		}else {
			utility.generateLogReportError("Element is identified with Locator: \" + locator + \"with locator Type: \" + locatorType + \" the Element is not Displayed");
			takeScreenshot(driver);
		}
	}
	
	public static void selectByIndex(WebDriver driver, String locator, String locatorType, int indexValue) {
		
		WebElement ele = findElement(driver, locator, locatorType);
		
		Select option = new Select(ele);
		option.selectByIndex(indexValue);
		
	}
	
	public static void hoverElement(WebDriver driver, String locator, String locatorType) {
		
		Actions obj = new Actions(driver);
		
		WebElement ele = findElement(driver, locator, locatorType);
		
		obj.moveToElement(ele).perform();
//		obj.moveToElement(ele).click().build().perform();		
	}
	
	public static void explicitWait(WebDriver driver, int Seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void takeScreenshot(WebDriver driver) {
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		File DestFile = new File("");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
