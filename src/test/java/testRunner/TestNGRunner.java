package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features/EmployeeManagement.feature",
		glue="stepDefinitions",
		monochrome=true,
		dryRun=false,
//		tags= "@myTest",
		plugin= {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
