package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
	public WebDriver driver;
	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Tab elements
    @FindBy(linkText = "Personal Details")
    private WebElement personalDetailsTab;

    @FindBy(linkText = "Contact Details")
    private WebElement contactDetailsTab;

    @FindBy(linkText = "Emergency Contacts")
    private WebElement emergencyContactsTab;

    @FindBy(linkText = "Dependents")
    private WebElement dependentsTab;

    @FindBy(linkText = "Immigration")
    private WebElement immigrationTab;

    @FindBy(linkText = "Job")
    private WebElement jobTab;

    @FindBy(linkText = "Salary")
    private WebElement salaryTab;

    @FindBy(linkText = "Report-to")
    private WebElement reportToTab;

    @FindBy(linkText = "Qualifications")
    private WebElement qualificationsTab;

    @FindBy(linkText = "Memberships")
    private WebElement membershipsTab;
    
    //Contact Details tab Elements
    
    @FindBy(xpath="//input[@class='oxd-input oxd-input--focus']")
    private WebElement homeTelephoneInput;
    
    //Emergency Contact tab Elements
    
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addEmergencyContactButton;

    @FindBy(xpath = "//label[text()='Name']/following-sibling::div/input")
    private WebElement emergencyContactNameInput;

    @FindBy(xpath = "//label[text()='Relationship']/following-sibling::div/input")
    private WebElement emergencyContactRelationshipInput;
    
    @FindBy(xpath = "//label[text()='Home Telephone']/following-sibling::div/input")
    private WebElement emergencyContactHomeTelephoneInput;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement emergencyContactCancelButton;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement emergencyContactSaveButton;
    
    // Success message popup elements

    @FindBy(xpath = "//div[@class='oxd-toast-container oxd-toast-container--bottom']")
    private WebElement successToastContainer;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']")
    private WebElement successToastTitle;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    private WebElement successToastMessage;

    @FindBy(xpath = "//div[@class='oxd-toast-close oxd-toast-close--success']")
    private WebElement closeToastButton;

    // Methods to interact with the tabs
    public void navigateToPersonalDetails() {
        personalDetailsTab.click();
    }

    public void navigateToContactDetails() {
        contactDetailsTab.click();
    }

    public void navigateToEmergencyContacts() {
        emergencyContactsTab.click();
    }

    public void navigateToDependents() {
        dependentsTab.click();
    }

    public void navigateToImmigration() {
        immigrationTab.click();
    }

    public void navigateToJob() {
        jobTab.click();
    }

    public void navigateToSalary() {
        salaryTab.click();
    }

    public void navigateToReportTo() {
        reportToTab.click();
    }

    public void navigateToQualifications() {
        qualificationsTab.click();
    }

    public void navigateToMemberships() {
        membershipsTab.click();
    }
    public void enterHomeTelephone(String phoneNumber) {
        homeTelephoneInput.clear();
        homeTelephoneInput.sendKeys(phoneNumber);
    }

    public void clickAddEmergencyContactButton() {
        addEmergencyContactButton.click();
    }

    public void enterEmergencyContactName(String name) {
    	emergencyContactNameInput.clear();
    	emergencyContactNameInput.sendKeys(name);
    }

    public void enterEmergencyContactRelationship(String relationship) {
    	emergencyContactRelationshipInput.clear();
        emergencyContactRelationshipInput.sendKeys(relationship);
    }
    
    public void enterEmergencyContactHomePhone(String phone) {
    	emergencyContactHomeTelephoneInput.clear();
    	emergencyContactHomeTelephoneInput.sendKeys(phone);
    }

    public void clickEmergencyContactCancelButton() {
    	emergencyContactCancelButton.click();
    }

    public void clickEmergencyContactSaveButton() {
    	emergencyContactSaveButton.click();
    }
    
    // Action Methods for Success Toast

    // Verify if the success toast is displayed
    public boolean isSuccessToastDisplayed() {
        try {
            return successToastContainer.isDisplayed();
        } catch (Exception e) {
            return false;  // If the toast is not present or not displayed
        }
    }

    // Get the success message text
    public String getSuccessToastMessage() {
        if (isSuccessToastDisplayed()) {
            return successToastMessage.getText();
        } else {
            return null;  // Return null if the success toast is not displayed
        }
    }

    // Get the title of the success message
    public String getSuccessToastTitle() {
        if (isSuccessToastDisplayed()) {
            return successToastTitle.getText();
        } else {
            return null;  // Return null if the success toast is not displayed
        }
    }

    // Click the close button on the success toast
    public void closeSuccessToast() {
        if (isSuccessToastDisplayed()) {
            closeToastButton.click();
        }
    }
}
