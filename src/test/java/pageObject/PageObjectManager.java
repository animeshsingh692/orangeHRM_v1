package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class PageObjectManager {
	public WebDriver driver;
	public WaitUtils waitUtils;
	
	public PageObjectManager(WebDriver driver, WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
	}
	
	public LoginPage getLoginPage() {
		return new LoginPage(driver);
	}
	
	public HomePage getHomePage() {
		return new HomePage(driver);
	}
	
	public DashboardPage getDashboardPage() {
		return new DashboardPage();
	}
	
	public MyInfoPage getMyInfoPage() {
		return new MyInfoPage(driver, waitUtils);
	}
	
	
	public EmployeeManagementPage getEmployeeManagementPage() {
		return new EmployeeManagementPage(driver, waitUtils);
	}
	
	public LeaveManagementPage getLeaveManagementPage() {
		return new LeaveManagementPage();
	}
	
	public TimeAndAttendancePage getTimeAndAttendancePage() {
		return new TimeAndAttendancePage();
	}
	
	public AdminModulePage getAdminModulePage() {
		return new AdminModulePage();
	}
	
	public PerformanceModulePage PerformanceModulePage() {
		return new PerformanceModulePage();
	}

}
