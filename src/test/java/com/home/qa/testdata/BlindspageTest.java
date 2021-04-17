package com.home.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.home.qa.base.TestBase;
import com.home.qa.pages.Blindspage;
import com.home.qa.pages.HomePage;
import com.home.qa.pages.Localadpage;
import com.home.qa.pages.WoodBlindspage;
import com.home.qa.util.TestUtil;


public class BlindspageTest extends TestBase{

	TestUtil testUtil;
	HomePage homepage;
	Localadpage localadpage;
	Blindspage blindspage;
	WoodBlindspage woodblindpage;
	
	
	public BlindspageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		intialization();
		testUtil = new TestUtil();
		 homepage = new HomePage();
		 localadpage = new Localadpage();
		 blindspage = new Blindspage();
		 woodblindpage= new WoodBlindspage();
		
	}
	
	@Test(priority = 1)
	public void WoodblindpageTest() throws InterruptedException {
		localadpage=homepage.home();
		blindspage=localadpage.blindsLink();
		woodblindpage=blindspage.Clickwoodblinds();
		woodblindpage.clickwidthandheight(prop.getProperty("width"),prop.getProperty("height"));
		 String title = woodblindpage.validateWoodBlindspageTitle();
			Assert.assertEquals(title, "Faux Wood Blinds | Custom Window Blinds | Blinds.com");
			driver.quit();
		
	}
//	@Test(priority = 1)
//	public void HompageTitleTest() {
//		String title = homepage.validateHompageTitle();
//	Assert.assertEquals(title, "The Home Depot");
//	}
//
//
//	@Test(priority = 2)
//	public void localadpageTest() {
//		localadpage=homepage.home();
//	}
}
