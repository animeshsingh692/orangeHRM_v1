package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.StaleElementReferenceException;

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
	@FindBy(xpath="(//label[normalize-space()='Employee Id']//parent::div)//following-sibling::div/input")
	WebElement employeeIdInput;
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchButton;
	// Result grid locators
	@FindBy(xpath="//hr//following::div/span[@class='oxd-text oxd-text--span']")
	WebElement recordsFoundText;
	@FindBy(xpath="//div[@class='oxd-table-card']")
	List<WebElement> searchResultsList;
	@FindBy(xpath = "//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')]")
    private List<WebElement> tableRows;
	@FindBy(xpath="(//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')])[1]//div[9]//button[2]")
	WebElement lastColumn; //delete button
	@FindBy(xpath="//ul[@class='oxd-pagination__ul']//li")
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
	@FindBy(xpath="//input[@type='file']")
	WebElement attachmentInput;
	@FindBy(xpath="//button[normalize-space()='Cancel']//following-sibling::button[normalize-space()='Save']")
	WebElement attachmentSaveButton;
	
	// Add Employee tab locators
	@FindBy(xpath="//a[normalize-space()=\"Add Employee\"]")
	WebElement addEmployeeTabButton;
	@FindBy(xpath="//input[@placeholder=\"First Name\"]")
	WebElement firstNameInput;
	@FindBy(xpath="//input[@placeholder=\"Last Name\"]")
	WebElement lastNameInput;
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
    	try{
    		employeeListTabButton.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
    }
	public void clickAddButton() {
	    try{
	    	addButton.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public void enterEmployeeIdInput(String id) {
		try{
			employeeIdInput.click();
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE)
			.keyUp(Keys.CONTROL).keyUp(Keys.BACK_SPACE).perform();
			employeeIdInput.sendKeys(id);
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public void clickSearchButton() {
		try{
			waitUtils.waitForElementToBeClickable(searchButton).click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	//Edit Employee action methods
	//Contact Details Sub Tab
	public void clickContactDetailsSubTab() {
		try{
			contactDetailsSubTab.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public void enterStreet1Input(String street1) {
		try{
			street1Input.click();		
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE)
			.keyUp(Keys.CONTROL).keyUp(Keys.BACK_SPACE).perform();
			street1Input.sendKeys(street1);
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public void enterMobileInput(String mobile) {
		try{
			mobileInput.click();
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE)
			.keyUp(Keys.CONTROL).keyUp(Keys.BACK_SPACE).perform();
			mobileInput.sendKeys(mobile);
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public String getStreet1Input() {
		try{
			return waitUtils.waitForElementToBeVisible(street1Input).getText();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        	return "";
        }catch(Exception e){
        	System.out.print(e.getMessage());
        	return "";
        }
	}
	public String getMobileInput() {
		try{
			return waitUtils.waitForElementToBeVisible(mobileInput).getText();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());       	
        }
		return "";
	}
	public void clickAddAttachementButton() {
		try{
			addAttachmentButton.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }			
	}
	public void uploadAttachment(String filepath) {
		try{
			attachmentInput.sendKeys(filepath);
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public void clickAttachmentSaveButton() {
		try{
			attachmentSaveButton.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public boolean isAttachmentAdded(String expectedFileName) {
		try{
			for (WebElement row : tableRows) {
	            String actualFileName = waitUtils.waitForElementToBeVisible(row.findElement(By.xpath(".//div[2]"))).getText(); // Second column
	            if (expectedFileName.equals(actualFileName)) {
	                return true; // Added File is available
	            }
	        }
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
		return false;
    }
	//Delete Employee popup action methods
    public void clickPopupCloseButton() {
    	try{
    		popupCloseButton.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
    }
    public void clickPopupCancelButton() {
    	try{
        	popupCancelButton.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
    }
    public void clickPopupDeleteButton() {
    	try{
        	waitUtils.waitForElementToBeClickable(popupDeleteButton).click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
    }
	//Add Employee tab
	public void clickAddEmployeeTabButton() {
		try{
			addEmployeeTabButton.click();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }	
	}
	public void enterFirstName(String firstName) {
		try{
			firstNameInput.clear();
		    firstNameInput.sendKeys(firstName);
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public void enterLastName(String lastName) {
		try{
			lastNameInput.clear();
		    lastNameInput.sendKeys(lastName);
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	public void clickSaveButton() {
		try{
			saveButton = waitUtils.waitForElementToBeClickable(saveButton);
			Actions action = new Actions(driver);
			action.moveToElement(saveButton).click(saveButton).perform();
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
	}
	//Success message toast popup action methods
    public String getSuccessToastMessage() { // Get the success message text
    	try {
    		return waitUtils.waitForElementToBeVisible(successToastMessage).getText();
    	}catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e) {
        	System.out.print(e.getMessage());
    	}
    	return "";
    }
    public String getSuccessToastTitle() { // Get the title of the success message
    	try {
    		return waitUtils.waitForElementToBeVisible(successToastTitle).getText();
    	}catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e) {
        	System.out.print(e.getMessage());
    	}
    	return "";
    }
    private boolean processEmployeeList(String id, String action) {
        int paginationItemsSize = paginationItemsList.size() - 1; // Exclude 'Previous' and 'Next'
        if(tableRows.size()==0) return false;
        int counter = 1;
        try {
	        do {
	            // Iterate through all rows
	            for (WebElement row : tableRows) {
	                String idColumnText = waitUtils.waitForElementToBeVisible(row.findElement(By.xpath(".//div[2]"))).getText(); // Second column
	                if (id.equals(idColumnText)) {
	                	switch(action) {
	                	case "openEmployeeRecord": 
	                		waitUtils.waitForElementToBeClickable(row.findElement(By.xpath(".//div[2]"))).click();
	                		break;
	                	case "deleteEmployeeRecord":
	                		waitUtils.waitForElementToBeClickable(row.findElement(By.xpath(".//div[9]//button[2]"))).click();
	                		break;
	                	default:
	                		break;
	                	}
	                    return true; // Employee found
	                }
	            }
	            
	            // Click pagination next if available
	            if (paginationNextButton.isDisplayed() && paginationNextButton.isEnabled()) {
	                paginationNextButton.click();
	                counter++;
	            } else {
	                break;
	            }
	        } while (counter <= paginationItemsSize);
        }catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e) {
        	System.out.print(e.getMessage());
    	}
        return false; // Employee not found
    }
    public boolean isEmployeeVisibleInList(String id) {
    	return processEmployeeList(id, "");
    }
    public void openEmployeeProfile(String id) {
    	boolean isFound = processEmployeeList(id, "openEmployeeRecord");
        if (!isFound) {
            System.out.println("<----------> Employee not present in database");
        }
    }
    public void clickDeleteIcon(String id) {
    	boolean isFound = processEmployeeList(id, "deleteEmployeeRecord");
        if (!isFound) {
            System.out.println("<----------> Employee not present in database");
        }
    }
    public String getRecordsFoundText() throws InterruptedException {
    	Thread.sleep(10000);
    	try {
    		return waitUtils.waitForElementToBeVisible(recordsFoundText).getText();
    	}catch(StaleElementReferenceException se) {
        	System.out.print(se.getMessage());
        }catch(Exception e) {
        	System.out.print(e.getMessage());
    	}
    	return "";
    }
}
