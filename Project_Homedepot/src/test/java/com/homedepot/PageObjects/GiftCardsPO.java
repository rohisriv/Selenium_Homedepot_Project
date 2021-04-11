
package com.homedepot.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GiftCardsPO {
	
WebDriver localdriver;
	
	public GiftCardsPO(WebDriver remotedriver) {
		
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	//PAGE OBJECTS FOR Giftcards test case
	
	@FindBy(xpath = "//*[@id=\"TasklinkList\"]/li[4]/a")
	@CacheLookup
	WebElement giftcards ;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[5]/div[2]/div[1]/div/div/a/picture/img")
	@CacheLookup
	WebElement shopnowbutton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[5]/div[2]/div/div[2]/form/span/select")
	@CacheLookup
	WebElement categoryDD;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[7]/span[2]/label")
	@CacheLookup
	WebElement whoisthisfor;
	
	@FindBy(name = "recipient Name")
	@CacheLookup
	WebElement recepientname;
	
	@FindBy(name = "senderName")
	@CacheLookup
	WebElement sendername;
	
	@FindBy(name = "senderMessage")
	@CacheLookup
	WebElement sendermessage;
	
	@FindBy(xpath = "(//button[@type='button'])[7]")
	@CacheLookup
	WebElement dollar50;
	
	@FindBy(xpath = "//span[contains(text(),'Buy Now')]")
	@CacheLookup
	WebElement buynowbutton;
	
	
	
	//*********************
	// METHODS FOR TC 4
	//*********************
	
	public void giftcardclick()
	{
		giftcards.click();
	}
	
	public void shopnowclick()
	{
		shopnowbutton.click();
	}
	
	public void categoryselect()
	{
		Select s = new Select(categoryDD);
		s.selectByValue("Birthday");
	}
	
	public void whoisthisforradio()
	{
		whoisthisfor.click();
	}
	
	public WebElement reciepientname()
	{
		return(recepientname);
	}
	
	public WebElement sendername()
	{
		return(sendername);
	}
	
	public WebElement sendermess()
	{
		return(sendermessage);
	}
		
	public void dollar50button()
	{
		dollar50.click();
	}
	
	public WebElement dollar50button1()
	{
		return(dollar50);
	}
	
	public void buynowbutton()
	{
		buynowbutton.click();
	}
	
	public WebElement buynowbutton1()
	{
		return(buynowbutton);
	}
	
	
}
