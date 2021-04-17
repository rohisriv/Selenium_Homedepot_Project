package com.home.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.home.qa.base.TestBase;
import com.home.qa.pages.HomePage;
import com.home.qa.pages.Huskypage;
import com.home.qa.pages.Localadpage;
import com.home.qa.pages.Toolbagspage;
import com.home.qa.util.TestUtil;

public class HuskypageTest extends TestBase{
	TestUtil testUtil;
	HomePage homepage;
	Localadpage localadpage;
	Huskypage huskypage;
	Toolbagspage toolbagspage;
	
	
	public HuskypageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		intialization();
		testUtil = new TestUtil();
		 homepage = new HomePage();
		 localadpage = new Localadpage();
		 huskypage = new Huskypage();
		 toolbagspage = new Toolbagspage();
	}
	

@Test(priority = 1)
public void HuskypageTest() throws InterruptedException {
	localadpage=homepage.home();
	huskypage=localadpage.clickOnhuskyLink();
	toolbagspage=huskypage.clickOnToolbags();
	Thread.sleep(2000);
	String title = toolbagspage.validateToolbagspageTitle();
		Assert.assertEquals(title, "Husky - Tool Bags - Tool Storage - The Home Depot");
	
	driver.close();
}



}
