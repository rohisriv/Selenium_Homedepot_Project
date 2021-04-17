package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class MantisTillerpage extends TestBase{

	@FindBy(xpath="//body/div[@id='container']/div[4]/div[3]/div[2]/div[1]/div[12]/div[7]/div[1]/a[1]/span[1]")
	WebElement Availability;
	
	
	public MantisTillerpage() {
		PageFactory.initElements(driver, this);
	}
	
	public CheckAvailabiltypage clickOnAvailability() {
		Availability.click();
		return new CheckAvailabiltypage();
	}
}
