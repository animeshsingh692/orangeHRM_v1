Feature: Employee Management
	
  Scenario: Add new employee with mandatory fields only
		Given the user is logged in
		And navigates to PIM > Add Employee
		When the user fills in mandatory fields with First Name "Jane", Last Name "Doe" and ID "JD001"
		And clicks the Save button
		Then a success popup should be displayed with "Success" in the title and "Successfully Saved" in the message
		And added employee with id "JD001" is visible in the employee list
	
	Scenario: Search employee by invalid ID
		Given the user is on the "Employee List" page
		When the user enters an invalid ID "InvalidID" in the search box
		And clicks the Search button
		Then the error message "No Records Found" should be displayed

	Scenario: Edit employee details
		Given the user is on the "Employee List" page
		When the user searches for an employee with ID "JD001"
		And the user opens the employee profile of "JD001"
		And updates the Address to "456 Maple St" and Phone to "+917654322787"
		And clicks the Save button
		Then the profile should be updated successfully
		And the new details for ID "JD001" should be visible, Address as "456 Maple St" and Phone as "+9876543"

	Scenario: Upload document to employee profile
		Given the user is on the employee profile of "JD001"
		When the user uploads a document "orangeHRM_v1_TestPlan.docx"
		And clicks the Save button of attchment section
		Then the document should be uploaded successfully
		And the document "orangeHRM_v1_TestPlan.docx" should be visible in the profile of "JD001"
	
	Scenario: Delete employee record
		Given the user is on the "Employee List" page
		When the user searches for an employee with ID "JD001"
		And clicks the Delete button for ID "JD001"
		And confirms the deletion
		Then the employee record with ID "JD001" should be removed from the employee list

