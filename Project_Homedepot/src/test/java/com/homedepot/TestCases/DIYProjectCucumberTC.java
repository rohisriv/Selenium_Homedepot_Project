package com.homedepot.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

//import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homedepot.PageObjects.DIYProjectListPageObj;

//import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.DataTableType;


public class DIYProjectCucumberTC {

    WebDriver driver;
    String baseURL;
    WebDriverWait wait;
    DIYProjectListPageObj diypageobj;
    private StringBuffer verificationErrors = new StringBuffer();
    List<Map<String, String>> page_link_heading;
	
	@Before
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass method called");
	}

	@After
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass method called");
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\gpall\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //wait = new WebDriverWait(driver, 30);
		diypageobj = PageFactory.initElements(driver, DIYProjectListPageObj.class);

        System.out.println("setUp method called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown method called");
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
	}

	/*@Test
	public void test() {
		System.out.println("Test method");
		//fail("Not yet implemented");
	}*/


	@Given("^user is on Home Depot web page:$")
	public void user_is_on_Home_Depot_web_page(List<String> arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
        driver.get("https://www.homedepot.com/");
        //Assert user is on homedepot.com page
        assertEquals(driver.getCurrentUrl(), arg1.get(0).toString());
		System.out.println(arg1.get(0).toString() + " user_is_on_Home_Depot_web_page");
	}

	@Given("^the browser window is maximized$")
	public void the_browser_window_is_maximized() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        driver.manage().window().maximize();
        Dimension size = driver.manage().window().getSize();
        int width1 = size.getWidth();
        int height1 = size.getHeight();
        System.out.println("Width" + width1 + "Height" + height1);  
        //assertEquals()
		System.out.println("the_browser_window_is_maximized");
		//throw new PendingException();
	}

	@When("^user points mouse over \"([^\"]*)\" link$")
	public void user_points_mouse_over_link(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println(arg1 + " user_points_mouse_over_link called");
        
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
            if(arg1.equals("DIY Projects & Ideas")) {
                if(op.getText().equals("DIY Projects & Ideas")){
                    actions = actions.moveToElement(op);
                    actions.perform();
                    wait.until(ExpectedConditions.visibilityOf(diypageobj.getDiyoptions()));
                    break;
                }
            }else if(arg1.equals("All Departments")) {
            	if(op.getText().equals("All Departments")) {
                    actions = actions.moveToElement(op);
                    actions.perform();
                    wait.until(ExpectedConditions.visibilityOf(diypageobj.getAlldept()));
                    break;
            	}
            }
        }    
	}

	@Then("^a dropdown should appear showing four columns:$")
	public void a_dropdown_should_appear_showing_four_columns(List<String> arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
        //Assert List header heading text as expected in backend
        WebElement diyoptions = diypageobj.getDiyoptions(); //driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        wait.until(ExpectedConditions.visibilityOfAllElements(diypageobj.getListsheading(diyoptions)));
        List<WebElement> listsheading = diypageobj.getListsheading(diyoptions); //diypageobj.getListsheading(); 
        int index = 1; //first row is the header in data table
        assertEquals(listsheading.size(), arg1.size()-1);
        for(WebElement op: listsheading){
            System.out.println("List header " + op.getText());
            assertEquals(op.getText(), arg1.get(index++));
        }

		System.out.println("a_dropdown_should_appear_showing_four_columns called");
		//throw new PendingException();
	}


	@Then("^\"([^\"]*)\" dropdown should disappear$")
	public void dropdown_should_disappear(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        WebElement alldept = diypageobj.getAlldept(); //driver.findElement(By.xpath("//*[@id=\"allDepartmentsFlyout\"]/section[1]/div"));
        //Assert DIY Projects list and ideas link is not displayed
        assertTrue(alldept.isDisplayed());

        WebElement diyoptions = diypageobj.getDiyoptions(); //driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        //isDisplayed() and isEnabled() are returning true values
        assertFalse(diyoptions.isSelected());
        //assertFalse(diyoptions.isDisplayed());

		//throw new PendingException();
	}

	@Then("^\"([^\"]*)\" list should have:$")
	public void list_should_have(String arg1, List<String> arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)

        Actions actions;
        actions = new Actions(driver);

        //Find list elements in individual list and assert they are equal to list elements as in backend
        //WebElement diyoptions = diypageobj.getDiyoptions(); //driver.findElement(By.xpath("//*[@id=\"diyFlyout\"]/section/div"));
        List<WebElement> diyoptionslist = diypageobj.getDiyoptionslist(); 
        System.out.println("diyoptionslist list size " + diyoptionslist.size());
        
        List<WebElement> listsheading = diypageobj.getListsheading(diypageobj.getDiyoptions()); //diypageobj.getListsheading(); 

        int index = 0;
        WebElement heading;
        for(WebElement op : diyoptionslist){
            System.out.println("diyoptionslist content " + op.toString());
            heading = listsheading.get(index);
            if(heading.getText().equals(arg1)){
                List<WebElement> list = diypageobj.getListitems(op);    //op.findElements(By.tagName("li"));
                System.out.println("list size " + list.size());
                assertEquals(list.size(), arg2.size());
                int index1 = 0;
                for(WebElement listop : list){
                    assertEquals(listop.getText(),arg2.get(index1));
                    actions = actions.moveToElement(listop);
                    actions.perform();
                    WebElement anchor = diypageobj.getAnchor(listop); //listop.findElement(By.tagName("a"));
                    String link = anchor.getText();
                    System.out.println("link " + link);
                    index1++;
                }
                break;
	        }
            index++;
        }
		//throw new PendingException();
	}	

	//@DataTableType
	@Given("^a list of page attributes in a table$")
	public void a_list_of_page_attributes_in_a_table(List<Map<String, String>> arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    //Map<String,String> pageattr = arg1.getTableConverter().toMap(arg1, String.class, String.class);
		page_link_heading = new ArrayList<Map<String, String>>(arg1);
		Map<String, String >pageattr = page_link_heading.get(35);
	    System.out.println("heading in page attr " + pageattr.get("link"));
	    System.out.println("heading in page attr " + pageattr.get("pageheading"));
		//throw new PendingException();
	}
	
	@When("^user points mouse over option \"([^\"]*)\" and clicks$")
	public void user_points_mouse_over_option_and_clicks(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		wait.until(ExpectedConditions.visibilityOfAllElements(diypageobj.getDiyoptionslist()));
		List<WebElement> diyoptionslist = diypageobj.getDiyoptionslist(); //diyoptions.findElements(By.tagName("ul"));
		System.out.println("diyoptionslist list size " + diyoptionslist.size());
 
        Actions actions = new Actions(driver);
        int found_link = 0;
        for(WebElement op : diyoptionslist){
            //System.out.println("diyoptionslist content " + op.toString());
            //System.out.println("diyoptionslist heading " + op.getText());

            List<WebElement> list = diypageobj.getListitems(op); //op.findElements(By.tagName("li"));
            System.out.println("list size " + list.size());

            for(WebElement listop : list){
                System.out.println("listop.getText() " + listop.getText());

            	if(listop.getText().equals(arg1)){
                    WebElement anchor = diypageobj.getAnchor(listop); //listop.findElement(By.tagName("a"));
                    String href = anchor.getAttribute("href");
                    System.out.println("Anchor href " + href);
                    if(!(href.equals(""))){
                        actions = actions.click(listop);//moveToElement(listop);
                        actions.perform();
                        //driver.findElement(By.tagName("h1")))
                    }
                    found_link = 1;
                    break;
                }
            }
            if(found_link==1) {
            	break;
            }
        }
    }

	@Then("^a page with page heading relevant to the option \"([^\"]*)\" should open$")
	public void a_page_with_page_heading_relevant_to_the_option_should_open(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        wait.until(ExpectedConditions.visibilityOf(diypageobj.getHeading()));
        //Page loaded correctly
        //driver.findElement(By.tagName("h1")).getText();
        String heading = diypageobj.getHeading().getText();
        System.out.println("Passed link " + arg1);
        String exp_heading = null;
        for(Map<String, String> pageattr : page_link_heading) {
        	if(pageattr.get("link").equals(arg1)) {
        		exp_heading = pageattr.get("pageheading");
        	}
        }
        assertEquals(heading, exp_heading);
	}
	
}
