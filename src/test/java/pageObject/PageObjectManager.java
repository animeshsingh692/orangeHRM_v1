package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
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
		return new MyInfoPage(driver);
	}
	
	
	public EmployeeManagementPage getEmployeeManagementPage() {
		return new EmployeeManagementPage();
	}
	
	public LeaveManagementPage getLeaveManagementPage() {
		return new LeaveManagementPage ();
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
