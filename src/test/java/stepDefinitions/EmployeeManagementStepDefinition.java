package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.EmployeeManagementPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.TestContextSetup;

public class EmployeeManagementStepDefinition {
	public TestContextSetup testContextSetup;
	public LoginPage loginPage;
	public EmployeeManagementPage employeeManagementPage;
	public HomePage homePage;
	public EmployeeManagementStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	@Given("the user is logged in")
    public void the_user_is_logged_in() {
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
    }
    @Given("navigates to PIM > Add Employee")
    public void navigates_to_PIM_Add_Employee() {
    	homePage = testContextSetup.pageObjectManager.getHomePage();
    	homePage.clickPimMenu();
    	employeeManagementPage = testContextSetup.pageObjectManager.getEmployeeManagementPage();
    	employeeManagementPage.clickAddEmployeeTabButton();
    }
    @When("the user fills in mandatory fields with First Name {string}, Last Name {string} and ID {string}")
    public void the_user_fills_in_mandatory_fields(String fname, String lname, String id) {
    	employeeManagementPage.enterFirstName(fname);
    	employeeManagementPage.enterLastName(lname);
    	employeeManagementPage.enterEmployeeIdInput(id);
    }
    @When("clicks the Save button")
    public void clicks_the_Save_button() {
    	employeeManagementPage.clickSaveButton();
    }
    @Then("a success popup should be displayed with {string} in the title and {string} in the message")
    public void verify_popup_title_and_message(String expectedToastTitle, String expectedToastMessage) {
    	String actualToastMessage = employeeManagementPage.getSuccessToastMessage();
    	String actualToastTitle = employeeManagementPage.getSuccessToastTitle();
    	if(actualToastTitle.equals(expectedToastTitle) && actualToastMessage.equals(expectedToastMessage)) {
    		Assert.assertTrue(true);
    	}else {
    		Assert.assertTrue(false);
    	}
    }
    @Then("added employee with id {string} is visible in the employee list")
    public void verify_added_employee_visible_in_employee_list(String id) {
    	employeeManagementPage.clickEmployeeListTabButton();
    	employeeManagementPage.enterEmployeeIdInput(id);
    	employeeManagementPage.clickSearchButton();
    	boolean status = employeeManagementPage.isEmployeeVisibleInList(id);
    	Assert.assertTrue(status);
    }
    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
    	loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        homePage = testContextSetup.pageObjectManager.getHomePage();
    	homePage.clickPimMenu();
    	employeeManagementPage = testContextSetup.pageObjectManager.getEmployeeManagementPage();
    	if(pageName.equals("Employee List")) employeeManagementPage.clickEmployeeListTabButton();
    }
    @When("the user enters an invalid ID {string} in the search box")
    public void the_user_enters_an_invalid_ID(String invalidId) {
    	employeeManagementPage.enterEmployeeIdInput(invalidId);
    }
    @When("clicks the Search button")
    public void clicks_the_Search_button() {
    	employeeManagementPage.clickSearchButton();
    }

    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expectedMessage) {
    	String actualMessage;
		try {
			actualMessage = employeeManagementPage.getRecordsFoundText();
			Assert.assertEquals(actualMessage, expectedMessage);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
    }

    @When("the user searches for an employee with ID {string}")
    public void the_user_searches_for_an_employee_with_ID(String employeeId) {
    	employeeManagementPage.enterEmployeeIdInput(employeeId);
        employeeManagementPage.clickSearchButton();
    }

    @When("the user opens the employee profile of {string}")
    public void the_user_opens_the_employee_profile(String id) {
    	employeeManagementPage.openEmployeeProfile(id);
    }

    @When("updates the Address to {string} and Phone to {string}")
    public void updates_the_Address_and_Phone(String address, String phone) {
    	employeeManagementPage.clickContactDetailsSubTab();
    	employeeManagementPage.enterStreet1Input(address);
    	employeeManagementPage.enterMobileInput(phone);
    	employeeManagementPage.clickSaveButton();
    }

    @Then("the profile should be updated successfully")
    public void the_profile_should_be_updated_successfully() {
    	String actualToastMessage = employeeManagementPage.getSuccessToastMessage();
    	String actualToastTitle = employeeManagementPage.getSuccessToastTitle();
    	if(actualToastTitle.equals("Success") && actualToastMessage.equals("Successfully Saved")) {
    		Assert.assertTrue(true);
    	}else {
    		Assert.assertTrue(false);
    	}
    }

    @Then("the new details for ID {string} should be visible, Address as {string} and Phone as {string}")
    public void the_new_details_should_be_updated_and_visible(String id, String expectedAddress, String expectedPhone) {
    	employeeManagementPage.clickEmployeeListTabButton();
    	employeeManagementPage.enterEmployeeIdInput(id);
        employeeManagementPage.clickSearchButton();
    	employeeManagementPage.openEmployeeProfile(id);
    	employeeManagementPage.clickContactDetailsSubTab();
    	String actualAddress = employeeManagementPage.getStreet1Input();
    	String actualPhone = employeeManagementPage.getMobileInput();
    	if(expectedAddress.equals(actualAddress) && expectedPhone.equals(actualPhone)) {
    		Assert.assertTrue(true);
    	}else {
    		Assert.assertTrue(false);
    	}
    }

    @Given("the user is on the employee profile of {string}")
    public void the_user_is_on_employee_profile(String id) {
    	loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        homePage = testContextSetup.pageObjectManager.getHomePage();
    	homePage.clickPimMenu();
    	employeeManagementPage = testContextSetup.pageObjectManager.getEmployeeManagementPage();
    	employeeManagementPage.clickEmployeeListTabButton();
    	employeeManagementPage.enterEmployeeIdInput(id);
        employeeManagementPage.clickSearchButton();
        employeeManagementPage.openEmployeeProfile(id);
    }
    @When("the user uploads a document {string}")
    public void the_user_uploads_a_document(String documentName) {
    	String filePath = System.getProperty("user.dir") + "//test-data//" +documentName;
    	employeeManagementPage.clickContactDetailsSubTab();
    	employeeManagementPage.clickAddAttachementButton();
    	employeeManagementPage.uploadAttachment(filePath);
    }
    @When("clicks the Save button of attchment section")
    public void clicks_the_Save_button_of_attchment_section() {
    	employeeManagementPage.clickAttachmentSaveButton();
    }
    @Then("the document should be uploaded successfully")
    public void the_document_should_be_uploaded_successfully() {
    	String actualToastMessage = employeeManagementPage.getSuccessToastMessage();
    	String actualToastTitle = employeeManagementPage.getSuccessToastTitle();
    	if(actualToastTitle.equals("Success") && actualToastMessage.equals("Successfully Saved")) {
    		Assert.assertTrue(true);
    	}else {
    		Assert.assertTrue(false);
    	}
    }
    @Then("the document {string} should be visible in the profile of {string}")
    public void verify_the_document_should_be_visible_in_the_profile(String expectedFileName, String id) {
    	employeeManagementPage.clickEmployeeListTabButton();
    	employeeManagementPage.enterEmployeeIdInput(id);
        employeeManagementPage.clickSearchButton();
        employeeManagementPage.openEmployeeProfile(id);
        employeeManagementPage.clickContactDetailsSubTab();
        boolean documentDisplayed = employeeManagementPage.isAttachmentAdded(expectedFileName);
    	Assert.assertTrue(documentDisplayed);
    }
    @When("clicks the Delete button for ID {string}")
    public void clicks_the_Delete_button(String id) {
    	employeeManagementPage.clickDeleteIcon(id);
    }
    @When("confirms the deletion")
    public void confirms_the_deletion() {
    	employeeManagementPage.clickPopupDeleteButton();
    }
    @Then("the employee record with ID {string} should be removed from the employee list")
    public void the_employee_record_should_be_removed(String employeeId) {
    	employeeManagementPage.clickEmployeeListTabButton();
    	employeeManagementPage.enterEmployeeIdInput(employeeId);
        employeeManagementPage.clickSearchButton();
    	boolean status = employeeManagementPage.isEmployeeVisibleInList(employeeId);
    	Assert.assertTrue(!status);
    }
}
