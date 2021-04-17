package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class Blindspage extends TestBase{

	@FindBy(xpath="//div[@class='aspect-ratio aspect-ratio--17x19']")
	WebElement woodblinds;
	
	public Blindspage() {
		PageFactory.initElements(driver, this);
		}
	
	public WoodBlindspage Clickwoodblinds() {
		woodblinds .click();
		return new WoodBlindspage();
	}
}
