package hdPallavi.Utilities;

//import java.io.File;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest testlogger;
	
		
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Rohini-Test-Report-"+timeStamp+".html";
		String repName1="Rohini-Test-Report-For-Jenkins.html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName1);//specify location of the report
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Rohini");
		
		htmlReporter.config().setDocumentTitle("Home Depot Test Project"); // Title of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public void onTestSuccess(ITestResult testresult)
	{
		testlogger=extent.createTest(testresult.getName()); // create new entry in the report
		testlogger.log(Status.PASS,MarkupHelper.createLabel(testresult.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult testresult)
	{
		testlogger=extent.createTest(testresult.getName()); // create new entry in the report
		testlogger.log(Status.FAIL,MarkupHelper.createLabel(testresult.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		/*String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		//System.out.println("Hi ............." + screenshotPath);
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + testlogger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}*/
		
	}
	
	public void onTestSkipped(ITestResult testresult)
	{
		testlogger=extent.createTest(testresult.getName()); // create new entry in the report
		testlogger.log(Status.SKIP,MarkupHelper.createLabel(testresult.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
