package com.home.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.home.qa.base.TestBase;
import com.home.qa.pages.Careerspage;
import com.home.qa.pages.HomePage;
import com.home.qa.pages.Localadpage;
import com.home.qa.pages.SearchJobspage;
import com.home.qa.util.TestUtil;

public class CareerspageTest extends TestBase{

	TestUtil testUtil;
	HomePage homepage;
	Localadpage localadpage;
	Careerspage careerspage;
	SearchJobspage searchjobspage;
	
	public CareerspageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		intialization();
		testUtil = new TestUtil();
		 homepage = new HomePage();
		 localadpage = new Localadpage();
		 careerspage = new Careerspage();
		 searchjobspage= new SearchJobspage();
	}
	
	@Test(priority = 1)
	public void CareerspageTest() throws InterruptedException {
		localadpage=homepage.home();
		careerspage=localadpage.clickOncareerLink();
		searchjobspage=careerspage.Clickapply();
		searchjobspage.clickOnjobs(prop.getProperty("job"));
		String title = searchjobspage.validateSearchJobspageTitle();
		Assert.assertEquals(title, "Search for Jobs at The Home Depot");
		Thread.sleep(2000);
		driver.close();
	}
}
