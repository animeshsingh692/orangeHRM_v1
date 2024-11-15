package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu;

    @FindBy(xpath = "//span[text()='Time']")
    private WebElement timeMenu;

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitmentMenu;

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//span[text()='Performance']")
    private WebElement performanceMenu;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//span[text()='Directory']")
    private WebElement directoryMenu;

    @FindBy(xpath = "//span[text()='Maintenance']")
    private WebElement maintenanceMenu;

    @FindBy(xpath = "//span[text()='Claim']")
    private WebElement claimMenu;

    @FindBy(xpath = "//span[text()='Buzz']")
    private WebElement buzzMenu;

    // Header elements
    @FindBy(className = "oxd-topbar-header-hamburger")
    private WebElement hamburgerMenuIcon;

    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")
    private WebElement headerTitle;

    @FindBy(className = "orangehrm-upgrade-button")
    private WebElement upgradeButton;

    @FindBy(className = "oxd-userdropdown-name")
    private WebElement userProfileName;

    @FindBy(xpath = "//button[@title='Help']")
    private WebElement helpButton;

    // Methods to interact with elements

    public void clickAdminMenu() {
        adminMenu.click();
    }

    public void clickPimMenu() {
        pimMenu.click();
    }

    public void clickLeaveMenu() {
        leaveMenu.click();
    }

    public void clickTimeMenu() {
        timeMenu.click();
    }

    public void clickRecruitmentMenu() {
        recruitmentMenu.click();
    }

    public void clickMyInfoMenu() {
        myInfoMenu.click();
    }

    public void clickPerformanceMenu() {
        performanceMenu.click();
    }

    public void clickDashboardMenu() {
        dashboardMenu.click();
    }

    public void clickDirectoryMenu() {
        directoryMenu.click();
    }

    public void clickMaintenanceMenu() {
        maintenanceMenu.click();
    }

    public void clickClaimMenu() {
        claimMenu.click();
    }

    public void clickBuzzMenu() {
        buzzMenu.click();
    }

    public void clickHamburgerMenuIcon() {
        hamburgerMenuIcon.click();
    }

    public String getHeaderTitle() {
        return headerTitle.getText();
    }

    public void clickUpgradeButton() {
        upgradeButton.click();
    }

    public String getUserProfileName() {
        return userProfileName.getText();
    }

    public void clickHelpButton() {
        helpButton.click();
    }
}
