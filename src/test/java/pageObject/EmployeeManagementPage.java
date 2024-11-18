package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtils;

public class EmployeeManagementPage {
	private WebDriver driver;
	private WaitUtils waitUtils;
	public EmployeeManagementPage(WebDriver driver,WaitUtils waitUtils) {
		this.driver = driver;
		this.waitUtils = waitUtils;
		PageFactory.initElements(driver, this);
	}
	
	// Employee List tab Locators
	@FindBy(xpath="//a[normalize-space()=\"Employee List\"]")
	WebElement employeeListTabButton;
	@FindBy(xpath="//button[normalize-space()=\"Add\"]")
	WebElement addButton;
	// Search Criteria input fields locators
	@FindBy(xpath="//label[normalize-space()='Employee Id']//following::div/input[1]")
	WebElement employeeIdInput;
	@FindBy(xpath="//button[normalize-space()=\"Search\"]")
	WebElement searchButton;
	// Result grid locators
	@FindBy(xpath="//hr//following::div/span[@class='oxd-text oxd-text--span']")
	WebElement recordsFoundText;
	@FindBy(xpath="//div[@class='oxd-table-card']")
	List<WebElement> searchResultsList;
	@FindBy(xpath="(//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')])[1]//div[2]")
	WebElement firstColumn;
	@FindBy(xpath="(//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')])[1]//div[9]//button[2]")
	WebElement lastColumn; //delete button
	@FindBy(xpath="//div[@class='oxd-pagination__ul']")
	List<WebElement> paginationItemsList;
	@FindBy(xpath="//button[contains(@class,'oxd-pagination-page-item--previous-next')]")
	WebElement paginationNextButton;
	//Delete popup locators
	@FindBy(css = ".oxd-dialog-close-button")
    private WebElement popupCloseButton;
    @FindBy(xpath="//button[normalize-space()='No, Cancel']")
    private WebElement popupCancelButton;
    @FindBy(css = ".oxd-button--label-danger")
    private WebElement popupDeleteButton;
    
	//Edit Employee locators
	//Contact Details Sub Tab
	@FindBy(xpath="//a[normalize-space()=\"Contact Details\"]")
	WebElement contactDetailsSubTab;
	@FindBy(xpath="//label[normalize-space()='Street 1']//following::input[1]")
	WebElement street1Input;
	@FindBy(xpath="//label[normalize-space()='Mobile']//following::input[1]")
	WebElement mobileInput;
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement addAttachmentButton;
	@FindBy(xpath="//div[@class='oxd-file-input-div']")
	WebElement attachmentInput;
	
	// Add Employee tab locators
	@FindBy(xpath="//a[normalize-space()=\"Add Employee\"]")
	WebElement addEmployeeTabButton;
	@FindBy(xpath="//input[@placeholder=\"First Name\"]")
	WebElement firstNameInput;
	@FindBy(xpath="//input[@placeholder=\"Last Name\"]")
	WebElement lastNameInput;
	@FindBy(xpath="//label[normalize-space()='Employee Id']//following::div/input")
	WebElement empIdInput;
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement saveButton;
	
	//Success message toast popup locators
	@FindBy(id = "oxd-toaster_1")
    private WebElement successToastContainer;
    @FindBy(xpath = "//p[contains(@class,'oxd-text--toast-title')]")
    private WebElement successToastTitle;
    @FindBy(xpath = "//p[contains(@class,'oxd-text--toast-message')]")
    private WebElement successToastMessage;
    @FindBy(xpath = "//div[contains(@class,'oxd-toast-close--success')]")
    private WebElement successToastCloseButton;
    
    //Employee List tab action methods
    public void clickEmployeeListTabButton() {
    	employeeListTabButton.click();
    }
	public void clickAddButton() {
	    addButton.click();
	}
	public void enterEmployeeIdInput(String id) {
		employeeIdInput.clear();
		employeeIdInput.sendKeys(id);
	}
	public void clickSearchButton() {
		searchButton.click();
	}
	//Edit Employee action methods
	//Contact Details Sub Tab
	public void clickContactDetailsSubTab() {
		contactDetailsSubTab.click();
	}
	public void enterStreet1Input(String street1) {
//		street1Input.click();
		Actions action = new Actions(driver);
		action.click(street1Input).keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE)
		.keyUp(Keys.CONTROL).keyUp(Keys.BACK_SPACE).perform();
		street1Input.sendKeys(street1);
	}
	public void enterMobileInput(String mobile) {
		mobileInput.click();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE)
		.keyUp(Keys.CONTROL).keyUp(Keys.BACK_SPACE).perform();
		mobileInput.sendKeys(mobile);
	}
	public String getStreet1Input() {
		return street1Input.getText();
	}
	public String getMobileInput() {
		return mobileInput.getText();
	}
	public void clickAddAttachementButton() {
		addAttachmentButton.click();
	}
	public void uploadAttachment(String filepath) {
		attachmentInput.clear();
		attachmentInput.sendKeys(filepath);
	}
	public boolean isAttachmentAdded(String expectedFileName) {
    	int searchResultsSize = searchResultsList.size();
    	for(int i=0; i<searchResultsSize; i++) {
			String actualFileName = firstColumn.getText();
			if(expectedFileName.equals(actualFileName)) return true;
		}
    	return false;
    }
	//Delete Employee popup action methods
    public void clickPopupCloseButton() {
    	popupCloseButton.click();
    }
    public void clickPopupCancelButton() {
    	popupCancelButton.click();
    }
    public void clickPopupDeleteButton() {
    	popupDeleteButton.click();
    }
	//Add Employee tab
	public void clickAddEmployeeTabButton() {
		addEmployeeTabButton.click();	
	}
	public void enterFirstName(String firstName) {
		firstNameInput.clear();
	    firstNameInput.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		lastNameInput.clear();
	    lastNameInput.sendKeys(lastName);
	}
	public void enterEmployeeId(String empId) {
		empIdInput.click();
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE)
		.keyUp(Keys.CONTROL).keyUp(Keys.BACK_SPACE).perform();
		empIdInput.sendKeys(empId);
	}
	public void clickSaveButton() {
		Actions action = new Actions(driver);
		action.moveToElement(saveButton).click(saveButton).perform();
	}
	//Success message toast popup action methods
    public String getSuccessToastMessage() { // Get the success message text
    	try {
    		return waitUtils.waitForElementToBeVisible(successToastMessage).getText();
    	}catch(Exception e) {
    		return null;
    	}
    }
    public String getSuccessToastTitle() { // Get the title of the success message
    	try {
    		return waitUtils.waitForElementToBeVisible(successToastTitle).getText();
    	}catch(Exception e) {
    		return null;
    	}
    }
    public boolean isEmployeeVisibleInList(String id) {
    	employeeIdInput.clear();
		employeeIdInput.sendKeys(id);
		searchButton.click();
    	int paginationItemsSize = paginationItemsList.size()-2;
    	int counter = 0;
    	int searchResultsSize = searchResultsList.size();
    	while(counter < paginationItemsSize) {
    		for(int i=0; i<searchResultsSize; i++) {
    			String idColumnText = firstColumn.getText();
    			if(id.equals(idColumnText)) return true;
    		}
    		paginationNextButton.click();
    		counter++;
    	}
    	return false;
    }
    public void clickFirstColumn() {
    	firstColumn.click();
    }
    public void clickDeleteIcon(String id) {
    	int paginationItemsSize = paginationItemsList.size()-2;
    	int counter = 0;
    	int searchResultsSize = searchResultsList.size();
    	while(counter <= paginationItemsSize) {
    		for(int i=0; i<searchResultsSize; i++) {
    			String idColumnText = firstColumn.getText();
    			if(id.equals(idColumnText)) {
    				lastColumn.click();
    				return;
    			}
    		}
    		paginationNextButton.click();
    		counter++;
    	}
    }
    public String getRecordsFoundText() {
    	return recordsFoundText.getText();
    }
}
