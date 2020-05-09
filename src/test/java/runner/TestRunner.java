package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features=".//src//test//java//feature//GMO.feature",
		glue= {"stepDef","base"},
		dryRun=false,
		monochrome = true,
		strict=true,
		plugin= {"pretty","html:target/cucumber-report",
				"json:target/cucumber.json"}
		)

public class TestRunner {
}
