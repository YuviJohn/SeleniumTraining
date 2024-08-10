package Selenium.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;


import Selenium.drivers.webdriver;
import Selenium.pages.signup.signup;
public class SIT_testcases {
	
	
	static WebDriver driver;
	
	
	@BeforeClass
	public static WebDriver initialize() {
		
		driver = webdriver.setUp();
		return driver;
	}
	
	@Test(priority=1)
	public static void TC01() {
		signup.CreateAccountEnterDetails(driver, "Surya", "1234567890", "Password");
	}

}
