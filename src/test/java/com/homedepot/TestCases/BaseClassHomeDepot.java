package com.homedepot.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.homedepot.Utilities.ReadConfigHomeDepot;


public class BaseClassHomeDepot {
	
    ReadConfigHomeDepot readconfig = new ReadConfigHomeDepot();
	
	public String URL = readconfig.getApplicationURL();
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) 
	{
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			//ChromeOptions op = new ChromeOptions();
			//op.setHeadless(true);
			//op.addArguments("window-size=1920,1080");
			//driver = new ChromeDriver(op);
			driver = new ChromeDriver();
		}
		else if(br.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();			
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
								
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	/*@AfterMethod
	public void teardown() {
		driver.quit();
	}*/
	

}
