package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = 	"src/test/java/feature",
		glue ="stepdef",
		monochrome = true,
		dryRun = false,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
