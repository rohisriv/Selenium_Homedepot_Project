package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class Localadpage extends TestBase{

	@FindBy(xpath="//a[@href='//www.homedepot.com/c/tool_and_truck_rental']")
	WebElement rentalLink;
	
	@FindBy(xpath="//a[contains(text(),'Careers')]")
	WebElement careersLink;
	
	@FindBy(xpath  ="//img[@alt='Husky']")
	WebElement huskyLink;
					
	@FindBy(xpath = "//img[@alt='Blinds.com']")
	WebElement blindsLink;


	public Localadpage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLocaladpageTitle() {
		return driver.getTitle();
	}
	
	public ToolRentalpage clickOnrentalLink() {
		rentalLink.click();
		return new ToolRentalpage();
	}
	
	public Careerspage clickOncareerLink() {
		careersLink.click();
		return new Careerspage();
	}
	
	public Huskypage clickOnhuskyLink() {
		huskyLink.click();
		return new Huskypage();
	}
	
	public Blindspage blindsLink() {
		blindsLink.click();
		return new Blindspage();
	}


}
