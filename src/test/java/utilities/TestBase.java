package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	private WebDriver driver;
	Properties property;
	public WebDriver webDriverManager() throws IOException {
		property = new Properties();
		FileInputStream propertyFile = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
		property.load(propertyFile);
		if(driver == null) {
			String appURL = property.getProperty("appURL");
			String browser = property.getProperty("browser").toLowerCase();
			switch(browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				break;
			}
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		    driver.get(appURL);
		}
		return driver;
	}
}
