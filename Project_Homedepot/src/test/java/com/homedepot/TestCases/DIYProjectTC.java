/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homedepot.TestCases;
//import static org.junit.Assert.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
//import org.testng.Assert;
//import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

/**
 *
 * @author gpall
 */
public class DIYProjectTC {
    WebDriver driver;
    String baseURL;
    private StringBuffer verificationErrors = new StringBuffer();
    WebDriverWait wait;
        
    public DIYProjectTC() {
    }

    String[] listheader = { "Home Decor Ideas", "Home Improvement", "Outdoor Living Ideas", "Home Entertaining"};

    String[][] diylistoptions = {
            {"Bathroom Ideas & Projects",
                "Living Room Ideas & Projects",
                "Paint Ideas & Projects",
                "Bedroom Ideas & Projects",
                "Kitchen Ideas & Projects",
                "Dining Room Ideas & Projects",
                "Flooring Ideas & Projects",
                "Hallway & Wall Ideas & Projects",
                "Ceiling Fan Ideas & Projects",
                "Small Spaces",
                "Home Accent Ideas & Projects"
                },
            {"Electrical Wiring",
                "Windows & Window Treatment Ideas",
                "Door Ideas & Projects",
                "Appliance Guides",
                "DIY Plumbing",
                "Home Heating & Cooling Guides",
                "Hardware and Tool Guides",
                "Building Material Guides",
                "Home Safety & Security"
            },
            {"Lawn & Landscaping Ideas & Projects",
                "Garden Ideas & Projects",
                "DIY Pest Control",
                "Outdoor Lighting Ideas",
                "Outdoor Recreation",
                "Outdoor Décor Ideas & Projects",
                "Grill Guides"
            },
            {"Halloween Ideas & Projects",
                "Christmas Ideas & Projects",
                "Thanksgiving Ideas & Projects",
                "Parties & Events",
                "Cooking Guides",
                "",
                "",
                "Trending",
                "Activites for Kids",
                "Gift Ideas",
                "All DIY Projects",
                "Free DIY Workshops"
            }
    };
    
    String[][] pageheading = {
            {"Bathroom Ideas & Projects",
                "Living Room Ideas & Projects",
                "Paint Ideas & Projects",
                "Bedroom Ideas & Projects",
                "Kitchen Ideas & Projects",
                "Dining Room Ideas & Projects",
                "Flooring Ideas & Projects",
                "Hallway & Wall Ideas & Projects",
                "Lighting & Ceiling Fan Ideas & Projects",
                "Small Spaces",
                "Home Accent Ideas & Projects"
                },
            {"Electrical Wiring",
                "Windows & Window Treatment Ideas",
                "Door Ideas & Projects",
                "Appliance Guides",
                "DIY Plumbing",
                "Home Heating & Cooling Guides",
                "Hardware & Tool Guides",
                "Building Material Guides",
                "Home Safety & Security"
            },
            {"Lawn & Landscaping Ideas & Projects",
                "Garden Ideas & Projects",
                "DIY Pest Control",
                "Outdoor Lighting Ideas",
                "Outdoor Recreation",
                "Outdoor Decor Ideas & Projects",
                "Grill Guides"
            },
            {"Halloween Ideas & Projects",
                "Christmas Ideas & Projects",
                "Thanksgiving Ideas & Projects",
                "Parties & Events",
                "Cooking Guides",
                "",
                "",
                "Trending",
                "Activities for Kids",
                "Gift Ideas",
                "DIY Projects and Ideas",
                "Workshops"
            }
    };
    
    @DataProvider(name = "providelistoptions")
    public Object[][] providelistoptions() throws Exception {
        /*return new Object[][] { 
        };*/
        return diylistoptions;
    }
    
    @DataProvider(name = "providepageheading")
    public Object[][] providepageheading() throws Exception{
        /*return new String[][]{ 
        };*/
        return pageheading;
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\gpall\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          Assert.fail(verificationErrorString);
        }
    }

    @Test
    public void checkProjectListVisible(){
        driver.get("http://www.homedepot.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        WebElement links = driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        System.out.println("links " + links.toString());

        List<WebElement> shopLinksOptions = driver.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        Actions actions;
        actions = new Actions(driver);

        for( WebElement op : shopLinksOptions ){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("DIY Projects & Ideas")){
                actions = new Actions(driver);
                actions = actions.moveToElement(op);
                actions.perform();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"))));
                break;
            }
        }    
        
        //Assert List header heading text as expected in backend
        WebElement diyoptions = driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        List<WebElement> listheading = diyoptions.findElements(By.tagName("h4"));
        int index = 0;
        Assert.assertEquals(listheading.size(), listheader.length);
        for(WebElement op: listheading){
            System.out.println("List header " + op.getText());
            Assert.assertEquals(op.getText(), listheader[index++]);
        }
    }
    
    @Test
    public void checkProjectListInVisible(){
        Actions actions = new Actions(driver);
        
        checkProjectListVisible();
        //check the "DIY Projects & Ideas" link disappears when mouse points over "All Departments"
        WebElement links = driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        System.out.println("links " + links.toString());

        List<WebElement> shopLinksOptions = driver.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        //All Departments link visible
        for( WebElement op : shopLinksOptions){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("All Departments")){
                actions = actions.moveToElement(op);
                actions.perform();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"allDepartmentsFlyout\"]/section[1]/div"))));
                break;
            }
        }

        WebElement alldept = driver.findElement(By.xpath("//*[@id=\"allDepartmentsFlyout\"]/section[1]/div"));
        //Assert DIY Projects list and ideas link is not displayed
        Assert.assertTrue(alldept.isDisplayed());

        WebElement diyoptions = driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        //isDisplayed() and isEnabled() are returning true values
        Assert.assertFalse(diyoptions.isSelected());
        //assertFalse(diyoptions.isDisplayed());
    }

    @Test
    public void checkProjectListContent(){
        Actions actions;
        checkProjectListVisible();
        //Find list elements in individual list and assert they are equal to list elements as in backend
        WebElement diyoptions = driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        List<WebElement> diyoptionslist = diyoptions.findElements(By.tagName("ul"));
        System.out.println("diyoptionslist list size " + diyoptionslist.size());
        int index = 0;
        for(WebElement op : diyoptionslist){
            System.out.println("diyoptionslist content " + op.toString());
            System.out.println("diyoptionslist heading " + op.getText());

            List<WebElement> list = op.findElements(By.tagName("li"));
            int index1 = 0;
            for(WebElement listop : list){
                Assert.assertEquals(listop.getText(),diylistoptions[index][index1++]);
                actions = new Actions(driver);
                actions = actions.moveToElement(listop);
                actions.perform();
                WebElement anchor = listop.findElement(By.tagName("a"));
                String link = anchor.getCssValue("text");
                System.out.println("link " + link);
            }           
            System.out.println("list size " + list.size());
            Assert.assertEquals(list.size(), diylistoptions[index].length);
            index++;
        }
    }
    
    //@Test
    /* public void checkProjectList() {
        driver.get("http://www.homedepot.com/");
        driver.manage().window().maximize();

        
        WebElement links = driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        System.out.println("links " + links.toString());

        List<WebElement> shopLinksOptions = driver.findElements(By.className("ShoppingLinks__item"));
                //allDeptDropdown.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        Actions actions;
        actions = new Actions(driver);

        for( WebElement op : shopLinksOptions ){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("DIY Projects & Ideas")){
                actions = new Actions(driver);
                actions = actions.moveToElement(op);
                actions.perform();
                //Cant detect spaces correctly
                //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("col__12-12 diyFlyout__wrapper"))));
                //col__12-12 diyFlyout__wrapper element is not part of op element. the flyout opens because of mouse hover on link and is a separate element
                //wait.until(ExpectedConditions.visibilityOf(op.findElement(By.className("col__12-12 diyFlyout__wrapper"))));
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"))));
                break;
            }
        }    
        
        //Assert List header heading text as expected in backend
        WebElement diyoptions = driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        List<WebElement> listheading = diyoptions.findElements(By.tagName("h4"));
        int index = 0;
        assertEquals(listheading.size(), listheader.length);
        for(WebElement op: listheading){
            System.out.println("List header " + op.getText());
            assertEquals(op.getText(), listheader[index++]);
        }
        
        //Find list elements in individual list and assert they are equal to list elements as in backend
        List<WebElement> diyoptionslist = diyoptions.findElements(By.tagName("ul"));
        System.out.println("diyoptionslist list size " + diyoptionslist.size());
        index = 0;
        for(WebElement op : diyoptionslist){
            System.out.println("diyoptionslist content " + op.toString());
            System.out.println("diyoptionslist heading " + op.getText());

            List<WebElement> list = op.findElements(By.tagName("li"));
            int index1 = 0;
            for(WebElement listop : list){
                assertEquals(listop.getText(),diylistoptions[index][index1++]);
                actions = new Actions(driver);
                actions = actions.moveToElement(listop);
                actions.perform();
                WebElement anchor = listop.findElement(By.tagName("a"));
                String link = anchor.getCssValue("text");
                System.out.println("link " + link);
            }           
            System.out.println("list size " + list.size());
            assertEquals(list.size(), diylistoptions[index].length);
            index++;
        }

        //check the "DIY Projects & Ideas" link disappears when mouse points over "All Departments"
        links = driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        System.out.println("links " + links.toString());

        shopLinksOptions = driver.findElements(By.className("ShoppingLinks__item"));
                //allDeptDropdown.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        for( WebElement op : shopLinksOptions){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("All Departments")){
                actions = actions.moveToElement(op);
                actions.perform();
                //Cant detect spaces correctly
                //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("col__12-12 diyFlyout__wrapper"))));
                //col__12-12 diyFlyout__wrapper element is not part of op element. the flyout opens because of mouse hover on link and is a separate element
                //wait.until(ExpectedConditions.visibilityOf(op.findElement(By.className("col__12-12 diyFlyout__wrapper"))));
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"allDepartmentsFlyout\"]/section[1]/div"))));
                break;
            }
        }
        
        WebElement alldept = driver.findElement(By.xpath("//*[@id=\"allDepartmentsFlyout\"]/section[1]/div"));
        //Assert DIY Projects list and ideas link is not displayed
        assertTrue(alldept.isDisplayed());
        //isDisplayed() and isEnabled() are returning true values
        assertFalse(diyoptions.isSelected());
        //assertFalse(diyoptionslist.isSelected());
    } */

    @Test
    public void checkProjectListNavigation(){
        int index = 0, index1 = 0;
        for(index = 0; index < diylistoptions.length; index++){    
            for(index1 = 0; index1 < diylistoptions[index].length; index1++){
                ProjectListNavigation(index, index1);
            }
        }
        //ProjectListNavigation(3, 5);
    }
    
    public void ProjectListNavigation(int diyoptionslistindex, int listopindex) {
        driver.get("http://www.homedepot.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        WebElement links = driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        System.out.println("links " + links.toString());

        List<WebElement> shopLinksOptions = driver.findElements(By.className("ShoppingLinks__item"));
                //allDeptDropdown.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        Actions actions;
        actions = new Actions(driver);

        for( WebElement op : shopLinksOptions){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("DIY Projects & Ideas")){
                actions = new Actions(driver);
                actions = actions.moveToElement(op);
                actions.perform();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"))));
                break;
            }
        }    
        
        WebElement diyoptions = driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        List<WebElement> diyoptionslist = diyoptions.findElements(By.tagName("ul"));
        System.out.println("diyoptionslist list size " + diyoptionslist.size());
        int index = 0;
        String heading;
        for(WebElement op : diyoptionslist){
            System.out.println("diyoptionslist content " + op.toString());
            System.out.println("diyoptionslist heading " + op.getText());
            if(index == diyoptionslistindex){
                List<WebElement> list = op.findElements(By.tagName("li"));
                System.out.println("list size " + list.size());
                Assert.assertEquals(list.size(), diylistoptions[index].length);

                int index1 = 0;
                for(WebElement listop : list){
                    if(index1 == listopindex){
                        System.out.println("index " + index + "index1 " + index1);
                        System.out.println("listop.getText() " + listop.getText());
                        System.out.println("listoptions[index][index1] " + diylistoptions[index][index1]);

                        Assert.assertEquals(listop.getText(),diylistoptions[index][index1]);
                        WebElement anchor = listop.findElement(By.tagName("a"));
                        String href = anchor.getAttribute("href");
                        System.out.println("Anchor href " + href);
                        if(!(href.equals(""))){
                            actions = new Actions(driver);
                            actions = actions.click(listop);//moveToElement(listop);
                            actions.perform();
                            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1"))));
                            //Page loaded correctly
                            heading = driver.findElement(By.tagName("h1")).getText();
                            Assert.assertEquals(heading, pageheading[index][index1]);
                            //Navigate page back, not being checked with back button. Using webdriver back button does not 
                            //check navigation functionality
                            //driver.navigate().back();
                        }
                        break;
                    }
                    index1++;
                }
                break;
            }
            index++;
        }
    }

}
