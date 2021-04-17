package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class Careerspage extends TestBase{

	@FindBy(id="thd-home-takeover")
	WebElement apply;
	
	public Careerspage() {
		PageFactory.initElements(driver, this);
		}
	
	public SearchJobspage Clickapply() {
		apply.click();
		return new SearchJobspage();
	}
}
