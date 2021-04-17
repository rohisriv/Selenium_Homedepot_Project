package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class SearchJobspage extends TestBase{

	@FindBy(id="cws_jobsearch_keywords")
	WebElement keywords;
	
	@FindBy(xpath="//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/button[1]/i[1]")
    WebElement location;
	
	public SearchJobspage() {
		PageFactory.initElements(driver, this);
		}
	
	public void clickOnjobs(String job) {
		keywords.sendKeys(job);
		location.click();
		
	}
	public String validateSearchJobspageTitle() {
		return driver.getTitle();
	}
}
