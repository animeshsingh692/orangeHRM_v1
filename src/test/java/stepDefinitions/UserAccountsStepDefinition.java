package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.DashboardPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyInfoPage;
import utilities.TestContextSetup;

public class UserAccountsStepDefinition {
	public TestContextSetup testContextSetup;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public MyInfoPage myInfoPage;
    public HomePage homePage;

    public UserAccountsStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @When("the user enters a valid username {string} and password {string}")
    public void user_enters_valid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("clicks the {string} button")
    public void clicks_the_button(String buttonName) {
    	if(buttonName.equals("Login")) loginPage.clickLoginButton();
    	if(buttonName.equals("Reset Password")) loginPage.clickResetPasswordButton();
    }

    @Then("the user should be redirected to the {string} page")
    public void user_redirected_to_page(String pageName) {
    	homePage = testContextSetup.pageObjectManager.getHomePage();
        Assert.assertEquals(homePage.getHeaderTitle(), pageName);
    }

    @When("the user enters an invalid username {string} and password {string}")
    public void user_enters_invalid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("an error message {string} should be displayed")
    public void error_message_displayed(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.getInvalidCredentialsMessageText());
    }

    @When("the user clicks on the {string} link")
    public void user_clicks_on_link(String linkText) {
        loginPage.clickForgotPassword();
    }

    @When("enters a registered email {string}")
    public void user_enters_registered_email(String email) {
        loginPage.enterUsernameForForgotPassword(email);
    }

    @Then("a password reset confirmation message {string} should be displayed")
    public void password_confirmation_message_displayed(String message) {
        Assert.assertEquals(message, loginPage.getResetPasswordConfirmationMessageText());
    }

    @Given("the user is logged in and on the {string} page")
    public void user_logged_in_and_on_page(String pageName) {
    	myInfoPage = testContextSetup.pageObjectManager.getMyInfoPage();
    }

    @When("the user updates their contact information with phone number {string}")
    public void user_updates_contact_information(String phoneNumber) {
    	myInfoPage.navigateToContactDetails();
        myInfoPage.enterHomeTelephone(phoneNumber);
    }
    
    @When("updates their emergency contact with name as {string} and relation {string} and phone {string}")
    public void user_updates_emergency_contact(String contactName, String relation, String phone) {
        myInfoPage.navigateToEmergencyContacts();
        myInfoPage.clickAddEmergencyContactButton();
        myInfoPage.enterEmergencyContactName(contactName);
        myInfoPage.enterEmergencyContactRelationship(relation);
        myInfoPage.enterEmergencyContactHomePhone(phone);
    }

    @Then("a profile update confirmation message {string} should be displayed")
    public void profile_update_confirmation_displayed(String confirmationMessage) {
        Assert.assertEquals(confirmationMessage, myInfoPage.getSuccessToastTitle());
    }

    @Then("the updated information should be saved correctly")
    public void updated_information_saved_correctly() {
        Assert.assertTrue(myInfoPage.isSuccessToastDisplayed());
    }
}