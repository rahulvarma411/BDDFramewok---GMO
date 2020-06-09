package runner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features=".//src//test//java//feature",
		glue= {"stepDef","base"},
		dryRun=false,
		monochrome = true,
		tags = {"@test12"},
		strict=true,
		plugin= {"html:target/cucumber-report",
				"json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html"}
		)    

public class TestRunner {
	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig("extent-config.xml");;
	 }
}
