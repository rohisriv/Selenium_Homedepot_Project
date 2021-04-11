/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homedepot.TestCases;

import static java.util.Objects.isNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.homedepot.PageObjects.DIYProjectListPageObj;
import com.homedepot.TestCases.BaseClassHomeDepot;
import com.homedepot.Utilities.ReadTxtFile;
import static com.homedepot.Utilities.ReadTxtFile.txtFileread;

/**
 *
 * @author gpall
 */
public class DIYProjectTC extends BaseClassHomeDepot{
    //WebDriver driver;
    //String baseURL;
    private StringBuffer verificationErrors = new StringBuffer();
    WebDriverWait wait;
    String[][] datadiylistheader, datadiylistoptions, datadiypageheading;
    
    public DIYProjectTC() {
        System.out.println("DIYProjectTC constructor called ");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUpMethod(String browser) throws Exception {
        /*System.setProperty("webdriver.edge.driver", "C:\\Users\\gpall\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        */
        
        //Super method of the parent class should be called
       //super.setup(URL);

       wait = new WebDriverWait(driver, 30);
       
       System.out.println("DIYProjectTC setUpMethod called ");
        try{
            datadiylistheader = ReadTxtFile.txtFileread(".\\src\\test\\java\\com\\homedepot\\TestData\\diylistheader.txt");
            System.out.println("File read and write complete");
            if(!isNull(datadiylistheader)){
                for(int i = 0; i <datadiylistheader.length; i++){
                    for(int j = 0; j< datadiylistheader[i].length; j++ ){
                        System.out.println("datadiylistheader i = " + i + " j " + j + " " + datadiylistheader[i][j]);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Exception thrown " + e.getMessage());
            return;
        }

        try{
            datadiylistoptions = ReadTxtFile.txtFileread(".\\src\\test\\java\\com\\homedepot\\TestData\\diylistoptions.txt");
            System.out.println("File read and write complete");
            if(!isNull(datadiylistoptions)){
                for(int i = 0; i <datadiylistoptions.length; i++){
                    for(int j = 0; j< datadiylistoptions[i].length; j++ ){
                        System.out.println("datadiylistoptions i = " + i + " j " + j + " " + datadiylistoptions[i][j]);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Exception thrown " + e.getMessage());
            return;
        }
        
        try{
            datadiypageheading = ReadTxtFile.txtFileread(".\\src\\test\\java\\com\\homedepot\\TestData\\diypageheading.txt");
            System.out.println("File read and write complete");
            if(!isNull(datadiypageheading)){
                for(int i = 0; i <datadiypageheading.length; i++){
                    for(int j = 0; j< datadiypageheading[i].length; j++ ){
                        System.out.println("datadiypageheading i = " + i + " j " + j + " " + datadiypageheading[i][j]);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Exception thrown " + e.getMessage());
            return;
        }        
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        System.out.println("DIYProjectTC tearDownMethod called ");
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
    }
    
    @Test
    public void checkProjectListVisible(){
        
        //driver.get("http://www.homedepot.com/");
        //driver.manage().window().maximize();

        DIYProjectListPageObj diypageobj = PageFactory.initElements(driver, DIYProjectListPageObj.class);
        wait = new WebDriverWait(driver, 30);
        
        WebElement links = diypageobj.getLinks();   //driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        
        System.out.println("links " + links.toString());

        List<WebElement> shopLinksOptions = diypageobj.getShopLinksOptions();//driver.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        Actions actions;
        actions = new Actions(driver);

        for( WebElement op : shopLinksOptions ){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("DIY Projects & Ideas")){
                actions = actions.moveToElement(op);
                actions.perform();
                wait.until(ExpectedConditions.visibilityOf(diypageobj.getDiyoptions()));
                break;
            }
        }    

        //Assert List header heading text as expected in backend
        WebElement diyoptions = diypageobj.getDiyoptions(); //driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        wait.until(ExpectedConditions.visibilityOfAllElements(diypageobj.getListheading(diyoptions)));
        List<WebElement> listheading = diypageobj.getListheading(diyoptions); //diypageobj.getListheading(); 
        int index = 0;
        assertEquals(listheading.size(), datadiylistheader[0].length);
        for(WebElement op: listheading){
            System.out.println("List header " + op.getText());
            assertEquals(op.getText(), datadiylistheader[0][index++]);
        }
    }
    
    @Test
    public void checkProjectListInVisible(){
        checkProjectListVisible();
        
        DIYProjectListPageObj diypageobj = PageFactory.initElements(driver, DIYProjectListPageObj.class);

        Actions actions = new Actions(driver);
        
        //check the "DIY Projects & Ideas" link disappears when mouse points over "All Departments"
        WebElement links = diypageobj.getLinks(); //driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        System.out.println("links " + links.toString());

        List<WebElement> shopLinksOptions = diypageobj.getShopLinksOptions(); //driver.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        //All Departments link visible
        for( WebElement op : shopLinksOptions){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("All Departments")){
                actions = actions.moveToElement(op);
                actions.perform();
                wait.until(ExpectedConditions.visibilityOf(diypageobj.getAlldept()));
                break;
            }
        }

        WebElement alldept = diypageobj.getAlldept(); //driver.findElement(By.xpath("//*[@id=\"allDepartmentsFlyout\"]/section[1]/div"));
        //Assert DIY Projects list and ideas link is not displayed
        assertTrue(alldept.isDisplayed());

        WebElement diyoptions = diypageobj.getDiyoptions(); //driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        //isDisplayed() and isEnabled() are returning true values
        assertFalse(diyoptions.isSelected());
        //assertFalse(diyoptions.isDisplayed());
    }

    @Test
    public void checkProjectListContent(){
        
        checkProjectListVisible();

        DIYProjectListPageObj diypageobj = PageFactory.initElements(driver, DIYProjectListPageObj.class);

        Actions actions;
        actions = new Actions(driver);

        //Find list elements in individual list and assert they are equal to list elements as in backend
        //WebElement diyoptions = diypageobj.getDiyoptions(); //driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        List<WebElement> diyoptionslist = diypageobj.getDiyoptionslist(); 
        System.out.println("diyoptionslist list size " + diyoptionslist.size());
        int index = 0;
        for(WebElement op : diyoptionslist){
            System.out.println("diyoptionslist content " + op.toString());

            List<WebElement> list = diypageobj.getListitems(op);    //op.findElements(By.tagName("li"));
            int index1 = 0;
            for(WebElement listop : list){
                assertEquals(listop.getText(),datadiylistoptions[index][index1]);
                actions = actions.moveToElement(listop);
                actions.perform();
                WebElement anchor = diypageobj.getAnchor(listop); //listop.findElement(By.tagName("a"));
                String link = anchor.getText();
                System.out.println("link " + link);
                index1++;
            }
            System.out.println("list size " + list.size());
            assertEquals(list.size(), datadiylistoptions[index].length);
            index++;
        }
    }
    
    @Test
    public void checkProjectListNavigation(){
        int index, index1;
        for(index = 0; index < datadiylistoptions.length; index++){    
            for(index1 = 0; index1 < datadiylistoptions[index].length; index1++){
                ProjectListNavigation(index, index1);
            }
        }
        //ProjectListNavigation(3, 5);
    }
    
    public void ProjectListNavigation(int diyoptionslistindex, int listopindex) {
        //driver.get("http://www.homedepot.com/");
        //driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 30);
        
        DIYProjectListPageObj diypageobj = PageFactory.initElements(driver, DIYProjectListPageObj.class);
        
        WebElement links = diypageobj.getLinks(); //driver.findElement(By.className("ShoppingLinks"));
        wait.until(ExpectedConditions.visibilityOf(links));
        System.out.println("links " + links.toString());

        List<WebElement> shopLinksOptions = diypageobj.getShopLinksOptions(); //driver.findElements(By.className("ShoppingLinks__item"));
        System.out.println("ShoppingLinks__item count" + shopLinksOptions.size());
        
        Actions actions;
        actions = new Actions(driver);

        for( WebElement op : shopLinksOptions){
            System.out.println("ShoppingLinks__item " + op.getText());
            if(op.getText().equals("DIY Projects & Ideas")){
                actions = actions.moveToElement(op);
                actions.perform();
                //driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div")))
                wait.until(ExpectedConditions.visibilityOf(diypageobj.getDiyoptions()));
                break;
            }
        }    
        
        wait.until(ExpectedConditions.visibilityOfAllElements(diypageobj.getDiyoptionslist()));
        List<WebElement> diyoptionslist = diypageobj.getDiyoptionslist(); //diyoptions.findElements(By.tagName("ul"));
        System.out.println("diyoptionslist list size " + diyoptionslist.size());
        String heading;
        
        WebElement op = diyoptionslist.get(diyoptionslistindex);
        System.out.println("diyoptionslist content " + op.toString());
        System.out.println("diyoptionslist heading " + op.getText());

        List<WebElement> list = diypageobj.getListitems(op); //op.findElements(By.tagName("li"));
        System.out.println("list size " + list.size());
        assertEquals(list.size(), datadiylistoptions[diyoptionslistindex].length);
        
        WebElement listop = list.get(listopindex);
        System.out.println("listop.getText() " + listop.getText());
        System.out.println("datadiylistoptions[diyoptionslistindex][listopindex] " + datadiylistoptions[diyoptionslistindex][listopindex]);

        assertEquals(listop.getText(),datadiylistoptions[diyoptionslistindex][listopindex]);
        WebElement anchor = diypageobj.getAnchor(listop); //listop.findElement(By.tagName("a"));
        String href = anchor.getAttribute("href");
        System.out.println("Anchor href " + href);
        if(!(href.equals(""))){
            actions = actions.click(listop);//moveToElement(listop);
            actions.perform();
            //driver.findElement(By.tagName("h1")))
            wait.until(ExpectedConditions.visibilityOf(diypageobj.getHeading()));
            //Page loaded correctly
            //driver.findElement(By.tagName("h1")).getText();
            heading = diypageobj.getHeading().getText();
            assertEquals(heading, datadiypageheading[diyoptionslistindex][listopindex]);
        }
    }
}
