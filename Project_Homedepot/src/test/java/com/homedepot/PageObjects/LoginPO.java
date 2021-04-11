
package com.homedepot.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPO {
	
WebDriver localdriver;
	
	public LoginPO(WebDriver remotedriver) {
		
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	//PAGE OBJECTS FOR TC1
	
	@FindBy(id = "headerMyAccount")
    @CacheLookup
    WebElement myacctlink;
	
	@FindBy(xpath = "//*[@id=\"SPSOSignIn\"]/a/span")
	@CacheLookup
	WebElement signinoption;
	
	@FindBy(id = "email")
	@CacheLookup
	WebElement emailtext;
	
	@FindBy(id = "password-input-field")
	@CacheLookup
	WebElement passwordtext;
	
	@FindBy(xpath = "//span[contains(text(),'Sign In')]")
	@CacheLookup
	WebElement signinbutton;
	
		
	@FindBy(xpath = "//p[contains(text(),'Welcome Back!')]")
	@CacheLookup
	WebElement welcomebacktext;
	
	
	//****************
	// METHODS FOR TC 1
	//****************
	
	public void myaccountclick()
	{
		myacctlink.click();
	}
	
	public void signinclick()
	{
		signinoption.click();
	}
	
	public WebElement enteremail()
	{
		return(emailtext);
	}
	
	public WebElement enterpassword()
	{
		return(passwordtext);
	}
	
	public void signinbutton()
	{
		signinbutton.click();
	}
	
	public WebElement welcomeback()
	{
		return(welcomebacktext);
	}
	
}
