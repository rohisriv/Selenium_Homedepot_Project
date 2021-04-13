package com.homedepot.TestCases;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*		tags= {"@TC4,@TC3,@TC2,@TC1"}, */
@RunWith(Cucumber.class)
@CucumberOptions(
		features="./feature",
		glue="com.homedepot.TestCases",
		monochrome=true,
		dryRun=false,
		plugin= {"pretty","html:test-output/Rohini_Report"}
		)
public class CucumberTestRunner {

}
