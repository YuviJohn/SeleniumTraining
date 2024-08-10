package Selenium.drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class webdriver {

	
	static String chromebrowserType = "webdriver.chrome.driver";
	static String chromebrowserPath = "D:\\Selenium\\Training\\Selenium\\src\\test\\java\\Selenium\\configfiles\\chromedriver\\chromedriver.exe";
	static String URL = "https://www.amazon.in/";
	
	
	public static WebDriver setUp() {
		
		System.setProperty(chromebrowserType, chromebrowserPath);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		
		return driver;
	
	
	}
	
	
	
	
}

