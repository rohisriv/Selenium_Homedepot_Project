package com.home.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home.qa.base.TestBase;

public class CheckAvailabiltypage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'Check Nearby Stores')]")
	WebElement nearbyStores;
	
	public CheckAvailabiltypage() {
		PageFactory.initElements(driver, this);
		
}

public Checknearbypage clickChecknearby() {
	nearbyStores.click();
	return new Checknearbypage();
	
}
}
