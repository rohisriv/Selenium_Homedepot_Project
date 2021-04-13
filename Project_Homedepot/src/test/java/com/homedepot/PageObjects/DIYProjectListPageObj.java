/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homedepot.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author gpall
 */
public class DIYProjectListPageObj {

    WebDriver driver;

    public DIYProjectListPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLinks() {
        return links;
    }

    public void setLinks(WebElement links) {
        this.links = links;
    }

    public List<WebElement> getShopLinksOptions() {
        return shopLinksOptions;
    }

    public void setShopLinksOptions(List<WebElement> shopLinksOptions) {
        this.shopLinksOptions = shopLinksOptions;
    }

    public List<WebElement> getListsheading(WebElement diyoptions) {
        //return getDiyoptions().findElements(By.tagName("h4"));
        List<WebElement> ret = diyoptions.findElements(By.tagName("h4")); 
        return ret;
        //return listsheading;
    }

    public void setListsheading(List<WebElement> listsheading) {
        this.listsheading = listsheading;
    }
    
    public WebElement getDiyoptions() {
        return diyoptions;
    }

    public void setDiyoptions(WebElement diyoptions) {
        this.diyoptions = diyoptions;
    }

    public List<WebElement> getDiyoptionslist() {
        return getDiyoptions().findElements(By.tagName("ul"));
        //return diyoptionslist;
    }

    /*public void setDiyoptionslist(List<WebElement> diyoptionslist) {
        this.diyoptionslist = diyoptionslist;
    }*/

    public List<WebElement> getListitems(WebElement op) {
        List<WebElement> listitemslocal = op.findElements(By.tagName("li"));
        return listitemslocal;
        //list;
    }

    /*public void setListitems(List<WebElement> listitems) {
        this.listitems = listitems;
    }*/

    public WebElement getAnchor(WebElement listop) {
        WebElement anchorlocal = listop.findElement(By.tagName("a"));
        return anchorlocal;
        
        //return anchor;  //listop.findElement(By.tagName("a"));
    }

    /*public void setAnchor(WebElement anchor) {
        this.anchor = anchor;
    }*/

    public WebElement getAlldept() {
        return alldept;
    }

    public void setAlldept(WebElement alldept) {
        this.alldept = alldept;
    }

    public WebElement getHeading() {
        return heading;
    }

    public void setHeading(WebElement heading) {
        this.heading = heading;
    }

    @FindBy(how = How.CLASS_NAME, using = "ShoppingLinks")
    private WebElement links;
    
    @FindBy(how = How.CLASS_NAME, using = "ShoppingLinks__item")
    private List<WebElement> shopLinksOptions;

    //@FindBy(how = How.TAG_NAME, using = "h4")
    private List<WebElement> listsheading;   //diyoptions.findElements(By.tagName("h4"));

    @FindBy(how = How.XPATH, using = "//*[@id=\"diyFlyout\"]/section/div")
    private WebElement diyoptions;
    
    //@FindBy(how = How.TAG_NAME, using = "ul")
    //private List<WebElement> diyoptionslist;    //diyoptions.findElements(By.tagName("ul"));

    //@FindBy(how = How.TAG_NAME, using = "li")
    //private List<WebElement> listitems;  //op.findElements(By.tagName("li"));
    
    //@FindBy(how = How.TAG_NAME, using = "a")
    //private WebElement anchor;  //listop.findElement(By.tagName("a"));
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"allDepartmentsFlyout\"]/section[1]/div")
    private WebElement alldept;
    
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement heading;
    
    

/*    @FindBy(xpath = ".//*[@name='userName']")
    private WebElement userName;

    @FindBy(xpath = ".//*[@name='password']")
    private WebElement password;

    @FindBy(xpath = ".//*[@name='submit']")
    private WebElement submitBtn;

    public void loginToFlighApplication(String uName, String pWord)
            throws Exception {
        try {
            driver.get("http://demo.guru99.com/test/newtours/index.php");
            userName.sendKeys(uName);
            password.sendKeys(pWord);
            submitBtn.click();
            //   LoginPage login = new LoginPage(driver);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
*/
}    

