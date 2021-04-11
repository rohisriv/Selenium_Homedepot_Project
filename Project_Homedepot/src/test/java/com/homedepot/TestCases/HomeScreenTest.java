package com.homedepot.TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.homedepot.PageObjects.GiftCardsPO;
import com.homedepot.PageObjects.HomeScreenPO;
import com.homedepot.PageObjects.LoginPO;
import com.homedepot.PageObjects.StoreFinderPO;
import com.homedepot.Utilities.XLUtils;


public class HomeScreenTest extends BaseClassHomeDepot {
	
	@Test
	public void login_001() throws InterruptedException, IOException
	{
		
		LoginPO lpo = new LoginPO(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement elem1,elem2;
		String path=System.getProperty("user.dir")+"/src/test/java/com/homedepot/TestData/JiraFormat_TC_Upload.xlsx";
		
		lpo.myaccountclick();
		Thread.sleep(2000);
		lpo.signinclick();
		Thread.sleep(2000);
		
		elem1=lpo.enteremail();
		String email = XLUtils.getCellData(path,"TestData",1,0);
		//String email = "testfntestln001@gmail.com";
		elem1.sendKeys(email);
		Thread.sleep(2000);
		
		
		elem2=lpo.enterpassword();	
		String pass = XLUtils.getCellData(path,"TestData",1,1);
		//String pass = "homedepotseleniumproject";
		elem2.sendKeys(pass);
		Thread.sleep(2000);
       
		
		System.out.println("Trying to click sign in button....");
		lpo.signinbutton();
		
		System.out.println("I have found the button....");
		Thread.sleep(4000);
		
		//lpo.myaccountclick();
		//String wel = lpo.welcomeback().getText();
		//System.out.println("The text on my account is .... " + wel);
		
		//Assert.assertEquals(wel,"Welcome Back");
		
		WebElement q = driver.findElement(By.xpath("//*[@id=\"single-signin__body\"]/div/div[1]/div/div/p"));
		String qs = q.getText();
		System.out.println(qs);
		
		Assert.assertEquals(qs, "Verification Code Entry");
		driver.quit();
		
		
	}
	
	@Test
	public void searchanitem_tc002() throws InterruptedException  
	{
		
		HomeScreenPO hspo = new HomeScreenPO(driver);
		 
		hspo.setsearch("wooden crates");
		hspo.clicksrchbtn();
		
		Thread.sleep(3000);
		hspo.clickwidthCB1();
		
		Thread.sleep(3000);
		hspo.clickheightCB1();
		
		Thread.sleep(3000);
		hspo.clickcolorCB1();
		
		Assert.assertTrue((hspo.getProdcolor_btn().isDisplayed()) && (hspo.getProdheight_btn().isDisplayed()) && (hspo.getProdwidth_btn().isDisplayed()));
		    
		driver.quit();
	}
	
	@Test
	public void findastore_003() throws InterruptedException, IOException
	{
		
		
		StoreFinderPO sfpo = new StoreFinderPO(driver);
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		String path=System.getProperty("user.dir")+"/src/test/java/com/homedepot/TestData/JiraFormat_TC_Upload.xlsx";
		
		System.out.println("We are in store finder TC.....");
		Thread.sleep(2000);
		System.out.println("I am going to click on the store finder link.....");
		sfpo.clickstorefinder();
		Thread.sleep(2000);
		
		String zipcode = XLUtils.getCellData(path,"TestData",1,6);
		System.out.println("The zip code is = "+ zipcode);
		sfpo.storeSearchBoxsendkeys(zipcode);
		Thread.sleep(2000);
		
		sfpo.storeSearchBoxButtonclick();
		Thread.sleep(2000);
		
		sfpo.showonlystorewithclick();
		Thread.sleep(2000);
		
		System.out.println("Clicking on select radius...");
		sfpo.radiusselect();
		Thread.sleep(2000);
		
		System.out.println("Clicking on 5 miles...");
		sfpo.radius5milesclick();
		Thread.sleep(2000);
		
		System.out.println("Clicking on truck rentals...");
		sfpo.homedepottruckrentalCBclick();
		Thread.sleep(2000);
		
		System.out.println("Clicking on apply filters...");
		sfpo.applyfiltersclick();
		Thread.sleep(2000);
		
		efw.executeScript("document.querySelector('body > section > div:nth-child(3) > div.col__4-12.col__4-12--sm.col__3-12--md.listFrame').scrollTop=500");
				
		System.out.println("Finding stores...");
		String s1 = sfpo.get_store1();
		System.out.println(s1);
		String s2 = sfpo.get_store2();
		System.out.println(s2);
		
		Assert.assertTrue(s1.equalsIgnoreCase("1 - Schaumburg #1904") && s2.equalsIgnoreCase("2 - Elk Grove Village #6701"));
		
		driver.quit();
		
	}
	
	@Test
	public void giftcards_004() throws InterruptedException, IOException
	{
		
		GiftCardsPO gcpo = new GiftCardsPO(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String path=System.getProperty("user.dir")+"/src/test/java/com/homedepot/TestData/JiraFormat_TC_Upload.xlsx";
		WebElement elem;
		
		captureScreen(driver,"beforegiftcardsclick");
		gcpo.giftcardclick();
		Thread.sleep(2000);
		
		gcpo.shopnowclick();
		Thread.sleep(2000);
		
		gcpo.categoryselect();
		Thread.sleep(2000);
		
		gcpo.whoisthisforradio();
		Thread.sleep(2000);
		
		System.out.println("Trying to input the recepient name....");
		
		String recename = XLUtils.getCellData(path,"TestData",1,3);	
		System.out.println("Recepient name = "+ recename);
		elem = gcpo.reciepientname();
		js.executeScript("arguments[0].scrollIntoView(true);",elem);
		elem.click();
		elem.clear();
		Thread.sleep(4000);
		js.executeScript("arguments[0].value='" + recename + "';", elem);
		elem.sendKeys(" ");
        elem.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(4000);
		
		String sendname = XLUtils.getCellData(path,"TestData",1,4);
		System.out.println("Sender name = "+ sendname);
		elem=gcpo.sendername();
		elem.click();
		elem.clear();
		Thread.sleep(4000);
		js.executeScript("arguments[0].value='" + sendname + "';", elem);
		elem.sendKeys(" ");
        elem.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(4000);
		
		String mess = XLUtils.getCellData(path, "TestData",1,5);
		System.out.println("Message name = "+ mess);
		elem=gcpo.sendermess();
		elem.click();
		elem.clear();
		Thread.sleep(4000);
		js.executeScript("arguments[0].value='" + mess + "';", elem);
		elem.sendKeys(" ");
        elem.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(4000);
		
		gcpo.dollar50button();
		Thread.sleep(2000);
		gcpo.buynowbutton();
		Thread.sleep(2000);
		
		System.out.println("The web elements have been selected ...");
				
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		
		assertEquals(driver.getTitle(),"The Home Depot Gift Cards by CashStar");
		
		driver.quit();
		
	}
	

}
