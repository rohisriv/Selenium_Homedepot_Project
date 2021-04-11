
package com.homedepot.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StoreFinderPO {
	
WebDriver localdriver;
	
	public StoreFinderPO(WebDriver remotedriver) {
		
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	
	
	//PAGE OBJECTS FOR TC3
	
	@FindBy(xpath = "//*[@id=\"TasklinkList\"]/li[1]/a")
	@CacheLookup
	WebElement storefinder_link;
	
	@FindBy(xpath = "//input[@id='storeSearchBox']")
	@CacheLookup
	WebElement storeSearchBox;
	
	@FindBy(xpath = "//body/section[1]/div[2]/div[1]/section[1]/div[2]/form[1]/div[2]/button[1]/span[1]")
	@CacheLookup
	WebElement storeSearchBoxButton;
	
	@FindBy(xpath = "//body/section[1]/div[2]/div[1]/section[2]/div[1]/label[1]")
	@CacheLookup
	WebElement showonlystorewith;
	
	@FindBy(xpath = "//select[@id='radius']")
	@CacheLookup
	WebElement radius;
	
	@FindBy(xpath = "//label[contains(text(),'Home Depot Truck Rental')]")
	@CacheLookup
	WebElement homedepottruckrentalCB;
	
	@FindBy(xpath = "//span[contains(text(),'Apply Filters')]")
	@CacheLookup
	WebElement applyfilters;
	
	@FindBy(xpath = "//*[@id=\"SFControl\"]/section/div[1]/div[1]/a/h1")
	@CacheLookup
	WebElement storeschaumburg;
	
	@FindBy(xpath = "//*[@id=\"SFControl\"]/section/div[2]/div[1]/a/h1")
	@CacheLookup
	WebElement storeelkgrove;
	
  //*********************
  // METHODS FOR TC 3
  //*********************
	
	public void clickstorefinder()
	{
		storefinder_link.click();
	}
	
	public void storeSearchBoxsendkeys(String zip)
	{
		storeSearchBox.sendKeys(zip);
	}
	
	public void storeSearchBoxButtonclick()
	{
		storeSearchBoxButton.click();
	}
	
	public void showonlystorewithclick()
	{
		showonlystorewith.click();
	}
	
	public void radiusselect()
	{
		radius.click();
	}
	
	public void radius5milesclick()
	{
		Select s = new Select(radius);
		s.selectByValue("5");
	}
	
	public void homedepottruckrentalCBclick()
	{
		homedepottruckrentalCB.click();
	}
	
	public void applyfiltersclick()
	{
		applyfilters.click();
	}
	
	public WebElement get_storeSchaumburg()
	{
		return(storeschaumburg);
	}
	
	public String get_store1()
	{
		String s = storeschaumburg.getText();
		return(s);
	}
	
	public WebElement get_storeelkgrove()
	{
		return(storeelkgrove);
	}
	
	public String get_store2()
	{
		String s = storeelkgrove.getText();
		return(s);
	}
	
}