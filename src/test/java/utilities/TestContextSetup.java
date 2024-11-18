package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObject.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public TestBase testBase;
	public WaitUtils waitUtils;
	public PageObjectManager pageObjectManager;
	public TestContextSetup() throws IOException{
		testBase = new TestBase();
		waitUtils = new WaitUtils(testBase.webDriverManager());
		pageObjectManager = new PageObjectManager(testBase.webDriverManager(), waitUtils);
	}
}
