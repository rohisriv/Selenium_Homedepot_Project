
package com.homedepot.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomeScreenPO {
	
WebDriver localdriver;
	
	public HomeScreenPO(WebDriver remotedriver) {
		
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	
	// PAGE OBJECTS FOR TC2
	
	@FindBy(id = "headerSearch")
    @CacheLookup
    WebElement ele_searchbox;
	
	@FindBy(id = "headerSearchButton")
	@CacheLookup
	WebElement ele_searchbtn;
	
	@FindBy(xpath = "//h2[contains(text(),'Product Width (in.)')]")
	@CacheLookup
	WebElement ele_prodwidthheader;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[6]/div[1]/section[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]")
	@CacheLookup
	WebElement ele_prodwidthCB1;
	
	@FindBy(xpath = "//h2[contains(text(),'Product Height (in.)')]")
	@CacheLookup
	WebElement ele_prodheightheader;
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[6]/div[1]/section[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]")
	@CacheLookup
	WebElement ele_prodheightCB1;
	
	@FindBy(xpath = "//h2[contains(text(),'Color Family')]")
	@CacheLookup
	WebElement ele_prodcolorheader;
	
	@FindBy(xpath = "//*[@id=\"browse-search-dimensions\"]/div/div[6]/div/div[2]/div/div[1]/div/label")
	@CacheLookup
	WebElement ele_prodcolor;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[5]/div[1]/div/button[1]/span")
	@CacheLookup
	WebElement prodwidth_btn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[5]/div[1]/div/button[2]/span")
	@CacheLookup
	WebElement prodheight_btn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[5]/div[1]/div/button[3]/span")
	@CacheLookup
	WebElement prodcolor_btn;
	
	
	
	/**
	 * @return the ele_prodwidthCB1
	 */
	public WebElement getEle_prodwidthCB1() {
		return ele_prodwidthCB1;
	}

	/**
	 * @param ele_prodwidthCB1 the ele_prodwidthCB1 to set
	 */
	public void setEle_prodwidthCB1(WebElement ele_prodwidthCB1) {
		this.ele_prodwidthCB1 = ele_prodwidthCB1;
	}

	/**
	 * @return the ele_prodheightCB1
	 */
	public WebElement getEle_prodheightCB1() {
		return ele_prodheightCB1;
	}

	/**
	 * @param ele_prodheightCB1 the ele_prodheightCB1 to set
	 */
	public void setEle_prodheightCB1(WebElement ele_prodheightCB1) {
		this.ele_prodheightCB1 = ele_prodheightCB1;
	}

	/**
	 * @return the ele_prodcolor
	 */
	public WebElement getEle_prodcolor() {
		return ele_prodcolor;
	}

	/**
	 * @param ele_prodcolor the ele_prodcolor to set
	 */
	public void setEle_prodcolor(WebElement ele_prodcolor) {
		this.ele_prodcolor = ele_prodcolor;
	}

	/**
	 * @return the prodwidth_btn
	 */
	public WebElement getProdwidth_btn() {
		return prodwidth_btn;
	}

	/**
	 * @return the prodheight_btn
	 */
	public WebElement getProdheight_btn() {
		return prodheight_btn;
	}

	/**
	 * @return the prodcolor_btn
	 */
	public WebElement getProdcolor_btn() {
		return prodcolor_btn;
	}

	
	public void setsearch(String name) {
		ele_searchbox.sendKeys(name);
    }
    
	public void clicksrchbtn() {
		ele_searchbtn.click();
	}
	
    public void clickwidthCB1() {
    	ele_prodwidthCB1.click();
    }
    
    public void clickheightCB1() {
    	ele_prodheightCB1.click();
    }
    
    public void clickcolorCB1()
	{
    	ele_prodcolor.click();
	}
    
  
}
