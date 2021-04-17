package com.home.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.home.qa.base.TestBase;

public class WoodBlindspage extends TestBase{

	@FindBy(id="SelectedWidth")
	WebElement widthlink;
	@FindBy(id="SelectedHeight")
	WebElement heightlink;
	@FindBy(xpath = "//div[contains(text(),'Update Prices Below')]")
	WebElement update;
	
	public WoodBlindspage() {
		PageFactory.initElements(driver, this);
		}
	
	public WoodBlindspage clickwidthandheight(String wid, String heig) {
		
		Select widthlink= new Select (driver.findElement(By.id("SelectedWidth")));
	  widthlink.selectByVisibleText(wid);
  
    Select heightlink= new Select (driver.findElement(By.id("SelectedHeight")));
    heightlink.selectByVisibleText(heig);
    update.click();
		return new WoodBlindspage();
		
	}
	
	public String validateWoodBlindspageTitle() {
		return driver.getTitle();
	}
}
