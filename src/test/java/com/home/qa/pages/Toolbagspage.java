package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class Toolbagspage extends TestBase{

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/div[3]/a[1]/img[1]")
	WebElement toolbags;
	
	public Toolbagspage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOntoolbags() {
		toolbags.click();
		
	}	
	
	public String validateToolbagspageTitle() {
		return driver.getTitle();
	}
}
