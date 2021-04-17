package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class ToolRentalpage extends TestBase{

	@FindBy(xpath = "//img[@title='Tillers']")
	WebElement tillers;
	
	public ToolRentalpage() {
		PageFactory.initElements(driver, this);
	}
	
//	public boolean verifyToolRental() {
//		return tillers.isDisplayed();
//	}
	
	
	public MantisTillerpage clickOnTillers() {
		tillers.click();
		return new MantisTillerpage();
	}
	
}
