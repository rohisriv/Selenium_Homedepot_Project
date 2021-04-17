package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class Huskypage extends TestBase{

	@FindBy(xpath="//img[@alt='Tool Bags']")
	WebElement Toolbagspage;
	
	public Huskypage() {
		PageFactory.initElements(driver, this);
	}
	
	public Toolbagspage clickOnToolbags() {
		Toolbagspage.click();
		return new Toolbagspage();
	}
}
