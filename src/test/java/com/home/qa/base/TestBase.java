package com.home.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.home.qa.util.TestUtil;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\rohin\\neweclipse-workspace\\HomeDepotProject_Combined\\src\\test\\java\\com\\home\\qa\\config\\config.properties") ;
			prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static void intialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rohin\\neweclipse-workspace\\HomeDepotProject_Combined\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
