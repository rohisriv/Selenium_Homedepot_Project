package com.homedepot.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.homedepot.Utilities.ReadConfigHomeDepot;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import org.testng.annotations.AfterMethod;


public class BaseClassHomeDepot {
	
    ReadConfigHomeDepot readconfig;
    public String baseURL;
    public WebDriver driver;

    public BaseClassHomeDepot(){
        System.out.println("BaseClassHomeDepot() constructor called");
        this.readconfig = new ReadConfigHomeDepot();
        this.baseURL = readconfig.getApplicationURL();
    }
        
    @Parameters("browser")
    @BeforeMethod
    public void setup(String br) 
    {
        System.out.println("BaseClassHomeDepot() setup called");

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
            else if(br.equals("edge")){
                    System.setProperty("webdriver.edge.driver","./Drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();			
            }

            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.get(this.baseURL);
            driver.manage().window().maximize();

    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
        Path sourcepath = source.toPath();
        Path targetpath = target.toPath();
        Files.copy(sourcepath, targetpath, REPLACE_EXISTING);
        //FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("BaseClassHomeDepot() teardown called");
        driver.quit();
    }
}
