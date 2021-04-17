package com.home.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.home.qa.base.TestBase;
import com.home.qa.pages.CheckAvailabiltypage;
import com.home.qa.pages.Checknearbypage;
import com.home.qa.pages.HomePage;
import com.home.qa.pages.Localadpage;
import com.home.qa.pages.MantisTillerpage;
import com.home.qa.pages.ToolRentalpage;
import com.home.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	HomePage homepage;
	Localadpage localadpage;
	ToolRentalpage toolRentalpage;
	TestUtil testUtil;
	MantisTillerpage mantisTillerpage;
	CheckAvailabiltypage checkAvailabiltypage;
	Checknearbypage checknearbypage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		intialization();
		testUtil = new TestUtil();
		 homepage = new HomePage();
		 localadpage = new Localadpage();
		 toolRentalpage= new ToolRentalpage();
		 mantisTillerpage = new MantisTillerpage();
		 checkAvailabiltypage = new CheckAvailabiltypage();
		 checknearbypage = new Checknearbypage();
		 
		 
	}
	@Test(priority = 1)
	public void HompageTitleTest() throws InterruptedException {
		String title = homepage.validateHompageTitle();
	Assert.assertEquals(title, "The Home Depot");
	localadpage=homepage.home();
	toolRentalpage=localadpage.clickOnrentalLink();
	mantisTillerpage=toolRentalpage.clickOnTillers();
	checkAvailabiltypage=mantisTillerpage.clickOnAvailability();
	checknearbypage=checkAvailabiltypage.clickChecknearby();
	checknearbypage.selectSearch(prop.getProperty("search"));
	String title1 = checknearbypage.validatesearchbyTitle();
	Assert.assertEquals(title1, "Mantis Mantis Tiller Rental 7262-00-02 - The Home Depot");
	Thread.sleep(2000);
	driver.close();
	}
	

//	@Test(priority = 2)
//	public void localadpageTest() {
//		localadpage=homepage.home();
//	}
//	
//	
//	@Test(priority = 3)
//	public void clickOnrentalLinkTest() {
//		toolRentalpage=localadpage.clickOnrentalLink();
//	}
//	
//	@Test(priority = 4)
//	public void clickOnTillers() {
//		mantisTillerpage=toolRentalpage.clickOnTillers();
//	}
//	
//	@Test(priority = 5)
//	public void clickOnAvailability() {
//		checkAvailabiltypage=mantisTillerpage.clickOnAvailability();
//	}
//	
//	@Test(priority = 6)
//	public void checknearbypageTest() {
//		checknearbypage=checkAvailabiltypage.clickChecknearby();
//	}
//	
//	@Test(priority = 7)
//	public void selectSearch() throws InterruptedException {
//		checknearbypage.selectSearch(prop.getProperty("search"));
//		Thread.sleep(2000);
//		driver.quit();
//	}
//	
//	

}
