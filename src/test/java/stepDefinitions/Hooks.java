package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utilities.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void quitBrowser() throws IOException {
		testContextSetup.testBase.webDriverManager().quit();
	}
	
	@AfterSuite
	public void addScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			WebDriver driver = testContextSetup.testBase.webDriverManager();
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(src);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
}
