package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Locators
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath="//button[contains(@class,'orangehrm-login-button')]")
    private WebElement loginButton;

    @FindBy(id = "divLogo") 
    private WebElement logo;

    @FindBy(xpath = "//p[contains(@class, 'orangehrm-login-forgot-header')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text') and text()='Invalid credentials']")
    private WebElement invalidCredentialsMessage;

    @FindBy(xpath = "//h6[contains(text(), 'Reset Password')]")
    private WebElement resetPasswordHeader;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement forgottenUsernameField; 

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-forgot-password-button--cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-forgot-password-button--reset')]")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
    private WebElement resetPasswordConfirmationMessage;

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isInvalidCredentialsMessageDisplayed() {
        return invalidCredentialsMessage.isDisplayed();
    }

    public String getInvalidCredentialsMessageText() {
        return invalidCredentialsMessage.getText();
    }

    public boolean isResetPasswordHeaderDisplayed() {
        return resetPasswordHeader.isDisplayed();
    }

    public void enterUsernameForForgotPassword(String username) {
        forgottenUsernameField.sendKeys(username);
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    public boolean isResetPasswordConfirmationMessageDisplayed() {
        return resetPasswordConfirmationMessage.isDisplayed();
    }

    public String getResetPasswordConfirmationMessageText() {
        return resetPasswordConfirmationMessage.getText();
    }
}
