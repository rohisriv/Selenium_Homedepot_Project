package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class Checknearbypage extends TestBase{

	@FindBy(id = "search-bar")
	WebElement search;
	
	public Checknearbypage() {
		PageFactory.initElements(driver, this);
		
}
	public String validatesearchbyTitle() {
		return driver.getTitle();
	}
	
	public Checknearbypage selectSearch(String sear) {
		search.clear();
		search.click();
		search.sendKeys(sear);
		
		return new Checknearbypage();
	}
}
