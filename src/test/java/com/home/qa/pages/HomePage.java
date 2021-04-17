package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'Local Ad')]")
	WebElement localad; 
	
	public HomePage() {
	PageFactory.initElements(driver, this);
	
		
	}
	
	public String validateHompageTitle() {
		return driver.getTitle();
	}
	
	public Localadpage home() {
		localad.click();
		return new Localadpage();
	}
}
