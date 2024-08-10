package Selenium.pages.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.drivers.seleniumdriver;


public class signup {
	
	//Locators
	
	// id, name, class, xpath, tagname, css selector
//	xpath basics:
//		absolute xpath(/) & relative Xpath(//)
//	xpath axes:
//		contains, starts-with, parent, following-sibling, ancestors
//	.*temporary.* 
	
	//*[contains(@id,'phone_number')]//parent::div
	//*[contains(@id,'phone_number')]
	
//	implicit wait, Explicit wait, thread.sleep
	
	
	static String mobilenumber_textbox_id = "ap_phone_number";//*[@id='ap_phone_number'] //*[@class='a-fixed-left-grid-inner']//*[@id='ap_phone_number']
	static String name_textbox_id = "ap_customer_name";
	static String password_textbox_id = "ap_password";
	static String continue_button_id = "continue";
	static String yourname_label_xpath = "//*[contains(@id,'customer_name')]//parent::div//*[contains(text(),'Your name')]";
	static String mobileNumber_label_xpath = "//*[@id='ap_phone_number']//parent::div//parent::div//parent::div//parent::div//*[contains(text(),'Mobile number')]";
	static String mobilenumberalert_label_xpath = "//*[@class='a-row']//following-sibling::*[@id='auth-phoneNumber-missing-alert']";
	static String allCategory_dropdown_id ="searchDropdownBox";
	
	
	public static void enterMobileNumber(WebDriver driver, String mobilenumber) {
		
//		seleniumdriver.explicitWait(driver, 20, mobilenumber_textbox_id);
		seleniumdriver.sendkeys(driver, mobilenumber_textbox_id, "id", mobilenumber);
		
	}
	
	public static void enterName(WebDriver driver, String Name) {
			
		seleniumdriver.sendkeys(driver, name_textbox_id, "id", Name);
			
		}
		
	public static void enterPassword(WebDriver driver, String password) {
		
		seleniumdriver.sendkeys(driver, password_textbox_id, "id", password);
		
	}

	public static void clickContinue(WebDriver driver) {
		
		seleniumdriver.click(driver, continue_button_id, "id");
		
		
	}

	public static void validatYourNameLabel(WebDriver driver) {
		
		seleniumdriver.validateElementDisplayed(driver, yourname_label_xpath, "xpath", "Name field is present");
	}
	
	
	public static void validateMobileNumberLabel(WebDriver driver) {
		
		seleniumdriver.validateElementDisplayed(driver, mobileNumber_label_xpath, "xpath", "Mobile number field is present");
	}
	
	public static void CreateAccountEnterDetails(WebDriver driver, String mobileNumber, String Name, String Password) {
		
		enterMobileNumber(driver, mobileNumber);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		enterName(driver, Name);
		
//		WebDriverWait wait = new WebDriverWait(20, driver);
//		wait.until(ExpectedConditions.visibilityOf(ele));
	
		enterPassword(driver, Password);
		
//		Thread.sleep(20);
		
		clickContinue(driver);
	}
	
	public static void selectCategory(WebDriver driver) {
		seleniumdriver.selectByIndex(driver, allCategory_dropdown_id, "id", 7);
	}
	
	
}
